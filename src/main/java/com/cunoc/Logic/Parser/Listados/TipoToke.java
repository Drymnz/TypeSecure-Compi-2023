package com.cunoc.Logic.Parser.Listados;

public enum TipoToke {
    OPERACION("OPEREACION"),
    DECLARACION("DECLARACION");
    private final String text;
    TipoToke(String text){
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
