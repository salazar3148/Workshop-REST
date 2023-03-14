package com.christian.workshop;
import java.util.*;

public class ProcessadorService {

    public Documento validarLineas(String ruta) {
        Documento doc = new Documento();

        String emailRegex = "^[A-Za-z0-9+_\\.-]+@[A-Za-z0-9\\.-]+\\.[A-Za-z]{2,}$";
        Set<String> set = new HashSet<String>(Arrays.asList(
                "Haematologist", "Phytotherapist", " Building surveyor", "Insurance",
                "account manager", "Educational psychologist"
        ));

        List<String[]> lineas = leerArchivo(ruta);
        for(int i = 1; i < lineas.size(); i++) {
            String[] linea = lineas.get(i);
            if(linea[5].matches(emailRegex) && set.contains(linea[8]))
                doc.incrementarValidos();
            else doc.incrementarNoValidos();
        }
        return doc;
    }
    public List leerArchivo(String ruta) {
        LectorArchivo archivo = validarArchivo(ruta);
        if(archivo != null){
            return archivo.leerArchivo(ruta);
        } else {
            throw new IllegalArgumentException("Tipo de archivo no válido");
        }
    }
    public LectorArchivo validarArchivo(String ruta) {
        Set<String> set = new HashSet<String>(Arrays.asList("xlsx", "xls", "csv"));
        String extension = ruta.split("\\.")[1];
        LectorArchivo archivo = null;

        if(set.contains(extension)) {
            if(extension.equals("csv")){
                archivo = new LectorCSV();
            } else {
                archivo = new LectorExcel();
            }
        } else {

        }
        return archivo;
    }
}
