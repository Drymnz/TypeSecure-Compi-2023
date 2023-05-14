package com.cunoc.Logic.Parser;

public class Toke {
    private final int fila;
    private final int columna;
    private final String lexema;

    protected Toke(int fila, int columna, String lexema) {
        this.fila = fila;
        this.columna = columna;
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getLexema() {
        return lexema;
    }
    
}
