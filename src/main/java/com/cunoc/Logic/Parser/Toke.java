package com.cunoc.Logic.Parser;

public class Toke {
    
    protected final int fila;
    protected final int columna;
    protected final String lexema;

    protected Toke(int fila, int columna, String lexema) {
        this.fila = columna;
        this.columna = fila;
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
    
    @Override
    public String toString() {
        return " Fila: " + this.fila + " Columna: " + this.columna +" Lexema: " + this.lexema;
    }
}
