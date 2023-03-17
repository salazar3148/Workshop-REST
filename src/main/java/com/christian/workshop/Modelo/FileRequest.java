package com.christian.workshop.Modelo;
import com.christian.workshop.Linea.Linea;

public class FileRequest {
    private Linea line;
    public FileRequest(){
    }
    public FileRequest(Linea line) {
        this.line = line;
    }
    public Linea getLine() {
        return line;
    }

}
