package com.christian.workshop.Lectura;

import com.christian.workshop.Linea.LineaCSV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LectorCSV implements LectorArchivo {

    private static final Logger logger = LogManager.getLogger(LectorCSV.class);
    @Override
    public List<LineaCSV> leerArchivo(String ruta) {
        List<LineaCSV> lineas = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/" + ruta);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            lineas = reader.lines()
                    .skip(1)
                    .map(LineaCSV::new)
                    .collect(Collectors.toList());
        } catch (Exception ex){
            logger.error("Error leyendo archivo de Excel", ex);
        }
        return lineas;
    }
}
