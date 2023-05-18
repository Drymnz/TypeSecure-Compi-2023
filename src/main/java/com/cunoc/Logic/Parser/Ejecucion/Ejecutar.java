package com.cunoc.Logic.Parser.Ejecucion;

import java.util.ArrayList;

import com.cunoc.Logic.Parser.Toke;
import com.cunoc.Logic.Parser.HijosToke.Declaracion;

public class Ejecutar {

    private ArrayList<Toke> ejecutar = new ArrayList<>(); 
    private ArrayList<Declaracion> variablesGlobal = new ArrayList<>(); 


    public Ejecutar(ArrayList<Toke> ejecutar){
        this.ejecutar = ejecutar;
    }

    public void ejecutar(){
        for (Toke iterable_element : ejecutar) {
           if (iterable_element instanceof Declaracion) {
            Declaracion castin = (Declaracion ) iterable_element;
            System.out.println(castin.datosVariables(variablesGlobal));
            variablesGlobal.add(castin);
           }
            //System.out.println(iterable_element.toString());
        }
        System.out.println(ejecutar.size()+"");
    }


}

