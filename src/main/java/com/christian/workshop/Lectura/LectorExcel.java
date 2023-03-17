package com.christian.workshop.Lectura;

import java.util.ArrayList;
import java.util.List;
import com.christian.workshop.Linea.Linea;
import com.christian.workshop.Linea.LineaExcel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LectorExcel implements LectorArchivo {

    private static final Logger logger = LogManager.getLogger(LectorExcel.class);
    @Override
    public List leerArchivo(String ruta) {
        List<Linea> lineas = new ArrayList<>();
        try {
            FileInputStream archivo = new FileInputStream(new File("src/main/resources/"+ruta));
            Workbook libroExcel = new XSSFWorkbook(archivo);
            Sheet hoja = libroExcel.getSheetAt(0);
            int columnas = hoja.getRow(0).getLastCellNum();
            lineas = StreamSupport.stream(hoja.spliterator(), false)
                    .skip(1)
                    .map(fila -> {
                        String[] linea = new String[columnas];
                        IntStream.range(0, columnas)
                                .forEach(i -> {
                                    Cell celda = fila.getCell(i);

                                    switch (celda.getCellType()) {
                                        case STRING:
                                            linea[i] = celda.getStringCellValue();
                                            break;
                                        case NUMERIC:
                                            linea[i] = Double.toString(celda.getNumericCellValue());
                                            break;
                                        case FORMULA:
                                            FormulaEvaluator evaluator = libroExcel.getCreationHelper().createFormulaEvaluator();
                                            CellValue cellValue = evaluator.evaluate(celda);
                                            if(cellValue.getCellType() == CellType.STRING) linea[i] = celda.getStringCellValue();
                                            else linea[i] = Double.toString(celda.getNumericCellValue());
                                            break;
                                        default:
                                            linea[i] = "";
                                            break;
                                    }
                                });
                        return new LineaExcel(linea);
                    })
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            logger.error("Error leyendo archivo de Excel", ex);
        }
        return lineas;
    }
}
