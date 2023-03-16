package com.christian.workshop.Lectura;

import com.christian.workshop.Lectura.LectorArchivo;
import com.christian.workshop.Lectura.LectorCSV;
import com.christian.workshop.Lectura.LectorExcel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TipoArchivo {
    public LectorArchivo obtenerTipo(String ruta) {
        String extension = ruta.split("\\.")[1];
        Map<String, LectorArchivo> archivoMap = new HashMap<>() {{
            put("csv", new LectorCSV());
            put("xlsx", new LectorExcel());
            put("xls", new LectorExcel());
        }};
        return archivoMap.get(extension);
    }
}
