package com.cunoc.Logic.Parser.Listados;

public enum TipoToke {
    DECLARACION("DECLARACION");
    private final String text;
    TipoToke(String text){
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
