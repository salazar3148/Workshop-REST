package com.christian.workshop.Service;
import com.christian.workshop.Lectura.LectorArchivo;
import com.christian.workshop.Linea.Linea;
import com.christian.workshop.Modelo.Documento;
import com.christian.workshop.Modelo.FileRequest;
import com.christian.workshop.Lectura.TipoArchivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ProcessadorService {

    private TipoArchivo tipoArchivo;

    @Autowired
    public ProcessadorService(TipoArchivo tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public Documento validarLineas(String ruta) {
        Documento doc = new Documento();
        List<Linea> lineas = leerArchivo(ruta);
        String extension = ruta.split("\\.")[1];
        lineas.stream()
                .forEach(linea -> {
                    FileRequest fileRequest = new FileRequest(linea);
                    RestTemplate restTemplate = new RestTemplate();
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    HttpEntity<FileRequest> request = new HttpEntity<>(fileRequest, headers);
                    boolean response = restTemplate.postForObject("http://localhost:8090/validator/", request, Boolean.class);
                    if(response)  doc.incrementarValidos();
                    else doc.incrementarNoValidos();
                });
        return doc;
    }
    public List leerArchivo(String ruta) {
        LectorArchivo archivo = tipoArchivo.obtenerTipo(ruta);
        if(archivo != null){
            return archivo.leerArchivo(ruta);
        } else {
            throw new IllegalArgumentException("Tipo de archivo no válido");
        }
    }
}
