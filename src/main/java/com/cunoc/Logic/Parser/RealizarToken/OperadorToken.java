package com.cunoc.Logic.Parser.RealizarToken;

import com.cunoc.Logic.Parser.HijosToke.Declaracion;
import com.cunoc.Logic.Parser.HijosToke.Valor;
import com.cunoc.Logic.Parser.Listados.TipoOperacion;

import java.util.ArrayList;

import com.cunoc.Logic.Parser.Toke;
import com.cunoc.Logic.Parser.Listados.TipoDato;

public class OperadorToken {

    private  Valor derecha;
    private  Valor izquierda;
    private final  Toke toke;
    private final TipoOperacion tipo;
    private final ArrayList<Declaracion> variablesGlobal;
    private boolean seguir = true;
    
    public OperadorToken(Valor derecha, Valor izquierda,TipoOperacion tipo,Toke toke,ArrayList<Declaracion> variablesGlobal) {
        this.derecha = derecha;
        this.izquierda = izquierda;
        this.tipo = tipo;
        this.toke = toke;
        this.variablesGlobal = variablesGlobal;
    }

    public Valor operar(){
        TipoDato tipoDato = this.getType();
        String valorRetornar = "";
        if (seguir) {
            switch (this.tipo) {
                case MULTIPLICAR:
                    double valorUno = Double.valueOf(this.izquierda.getLexema());
                    double valorDos = Double.valueOf(this.derecha.getLexema());
                    valorRetornar = (valorUno * valorDos) + "";
                    break;
            
                default:
                    break;
            }
        }
        return new Valor(this.toke.getFila(), this.toke.getColumna(), valorRetornar,tipoDato);
    }

    private TipoDato getType(){
        TipoDato tipoDato = TipoDato.BOOLEAN;
        if (this.derecha.getTipoDato() == TipoDato.VARIABLE) {
            this.derecha = this.regreasarVariable(this.derecha.getLexema());
            this.derecha.setTipoDato(this.izquierda.getTipoDato());
        }
        if (this.izquierda.getTipoDato() == TipoDato.VARIABLE) {
            this.izquierda = this.regreasarVariable(this.derecha.getLexema());
            this.izquierda.setTipoDato(this.derecha.getTipoDato());
        }
        System.out.println(this.izquierda.getTipoDato().toString());
        System.out.println(this.derecha.getTipoDato().toString());
        if (this.derecha.getTipoDato() == this.izquierda.getTipoDato()) {
            return this.derecha.getTipoDato();
        }
        this.seguir = false;
        System.out.println("No se puede ejecutar estos dos tipos de datos");
        return tipoDato;
    }

    private Valor regreasarVariable(String name){
        for (Declaracion iterable_element : this.variablesGlobal) {
            System.out.println(iterable_element.datosVariables(variablesGlobal));
            if (iterable_element.getNombre().equals(name)) {
                System.out.println(iterable_element.datosVariables(variablesGlobal));
                return new Valor(iterable_element);
            }
        }
        return null;
    }

}
