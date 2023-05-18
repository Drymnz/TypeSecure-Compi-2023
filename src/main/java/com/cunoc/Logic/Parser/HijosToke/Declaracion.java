package com.cunoc.Logic.Parser.HijosToke;

import java.util.ArrayList;

import com.cunoc.Logic.Parser.Toke;
import com.cunoc.Logic.Parser.Listados.TipoDato;
import com.cunoc.Logic.Parser.Listados.TipoVariable;

public class Declaracion extends Toke{

    private final TipoVariable tipoVariable;
    private final TipoDato tipoDato;
    private final String nombre;
    private String valorFinal = null;
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

    public String obtenerValorString(ArrayList<Declaracion> variablesGlobal) {
        if (this.valorFinal == null) {
            if (this.valor instanceof Valor) {
                Valor castin = (Valor) this.valor;
                this.valorFinal = castin.getLexema();
            }
            if (this.valor instanceof Operacion) {
                Operacion castin = (Operacion) this.valor;
                Valor segundoCastin = (Valor) castin.getValor(variablesGlobal);
                this.valorFinal = segundoCastin.getLexema();
            }
            return this.valorFinal + "";
        }else {
            return this.valorFinal;
        }
    }

    @Override
    public String toString() {
        String valorMostrar = (this.valor == null )? "null" : this.valor.toString();
        return "Declaracion< tipoVariable: " + this.tipoVariable +", tipoDato: "+this.tipoDato + ", nombre: "+this.nombre+", valor: "+ valorMostrar +  "> " + super.toString();
    }

    public String datosVariables(ArrayList<Declaracion> variablesGlobal){
        return "Variable < Nombre : " +this.nombre + " , Valor : " + this.obtenerValorString(variablesGlobal) + " >";
    }
}

