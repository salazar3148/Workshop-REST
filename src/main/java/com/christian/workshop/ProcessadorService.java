package com.christian.workshop;
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
        List<String[]> lineas = leerArchivo(ruta);
        String extension = ruta.split("\\.")[1];

        for(int i = 1; i < lineas.size(); i++) {
            String[] linea = lineas.get(i);

            FileRequest fileRequest = new FileRequest(linea, extension);
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<FileRequest> request = new HttpEntity<>(fileRequest, headers);

            boolean response = restTemplate.postForObject("http://localhost:8090/validator/", request, Boolean.class);

            if(response) doc.incrementarValidos();
            else doc.incrementarNoValidos();
        }
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
