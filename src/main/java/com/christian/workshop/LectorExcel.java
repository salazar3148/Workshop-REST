package com.christian.workshop;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;


public class LectorExcel implements LectorArchivo{
    @Override
    public List leerArchivo(String ruta) {
        List<String[]> lineas = new ArrayList<>();
        try {
        FileInputStream archivo = new FileInputStream(new File("src/main/resources/"+ruta));
        Workbook libroExcel = new XSSFWorkbook(archivo);

        Sheet hoja = libroExcel.getSheetAt(0);
        int columnas = hoja.getRow(0).getLastCellNum();

        for (Row fila : hoja) {
            String[] linea = new String[columnas];
            for (int i = 0; i < columnas; i++) {
                Cell celda = fila.getCell(i);

                switch (celda.getCellType()) {
                    case STRING:
                        linea[i] = celda.getStringCellValue();
                        break;
                    case NUMERIC:
                        linea[i] = Double.toString(celda.getNumericCellValue());
                        break;
                    default:
                        linea[i] = "";
                        break;
                }
            }
            lineas.add(linea);
        }
        archivo.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
        return lineas;
    }
}
