package com.cunoc.Logic.Parser.HijosToke;

import com.cunoc.Logic.Parser.Toke;
import com.cunoc.Logic.Parser.Listados.TipoDato;

public class Valor extends Toke{
    
    private TipoDato tipoDato;

    public Valor(int fila, int columna, String lexema, TipoDato tipoDato) {
        super(columna, fila, lexema);
        this.tipoDato = tipoDato;
    }

    public Valor(Declaracion usar){
        super(usar.getFila(), usar.getColumna(), usar.obtenerValorString(null));
        this.tipoDato = usar.getTipoDato();
    }

    public TipoDato getTipoDato() {
        return tipoDato;
    }


    @Override
    public String toString() {
        return " Valor < tipoDato: "+this.tipoDato + ">"+super.toString();
    }

    public void setTipoDato(TipoDato tipoDato) {
        this.tipoDato = tipoDato;
    }
}
