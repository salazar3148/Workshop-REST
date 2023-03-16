package com.christian.workshop.Modelo;

public class Documento {
    private int validos;
    private int noValidos;
    public Documento(){
        validos = 0;
        noValidos = 0;
    }
    public void incrementarValidos() {
        validos++;
    }
    public void incrementarNoValidos() {
        noValidos++;
    }
    public int getValidos() {
        return validos;
    }

    public int getNoValidos() {
        return noValidos;
    }
}
