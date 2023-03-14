package com.christian.workshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV implements LectorArchivo {
    @Override
    public List leerArchivo(String ruta) {
        List<String[]> lineas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + ruta));
            String line;
            while((line = br.readLine()) != null){
                lineas.add(line.split(","));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return lineas;
    }
}
