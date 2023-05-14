package com.cunoc.Logic.Parser.HijosToke;

import com.cunoc.Logic.Parser.Toke;
import com.cunoc.Logic.Parser.Listados.TipoDato;
import com.cunoc.Logic.Parser.Listados.TipoVariable;

public class Declaracion extends Toke{

    private final TipoVariable tipoVariable;
    private final TipoDato tipoDato;
    private final String nombre;
    private final Toke valor;

    /**
     * @param fila
     * @param columna
     * @param lexema
     */

    public Declaracion(int fila, int columna, String lexema, TipoVariable tipoVariable, TipoDato tipoDato,
            String nombre, Toke valor) {
        super(fila, columna, lexema);
        this.tipoVariable = tipoVariable;
        this.tipoDato = tipoDato;
        this.nombre = nombre;
        this.valor = valor;
    }

    public TipoVariable getTipoVariable() {
        return tipoVariable;
    }

    public TipoDato getTipoDato() {
        return tipoDato;
    }

    public String getNombre() {
        return nombre;
    }

    public Toke getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String valorMostrar = (this.valor == null )? "null" : this.valor.toString();
        return "Declaracion< tipoVariable: " + this.tipoVariable +", tipoDato: "+this.tipoDato + ", nombre: "+this.nombre+", valor: "+ valorMostrar +  ">";
    }
}

