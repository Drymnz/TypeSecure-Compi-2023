package com.cunoc.Logic.Parser.HijosToke;

import java.util.ArrayList;

import com.cunoc.Logic.Parser.Toke;
import com.cunoc.Logic.Parser.Listados.TipoOperacion;
import com.cunoc.Logic.Parser.RealizarToken.OperadorToken;

public class Operacion extends Toke{
    private final Toke derecha;
    private final Toke Izquierda;
    private final TipoOperacion tipo;
    private Valor resultadoFinal = null;

    public Operacion(int fila, int columna, String lexema, Toke derecha, Toke izquierda, TipoOperacion tipo) {
        super(fila, columna, lexema);
        this.derecha = derecha;
        Izquierda = izquierda;
        this.tipo = tipo;
    }

    public Toke getDerecha() {
        return derecha;
    }

    public Toke getIzquierda() {
        return Izquierda;
    }

    public TipoOperacion getTipo() {
        return tipo;
    }

    public Valor getValor(ArrayList<Declaracion> variablesGlobal){
        if (this.resultadoFinal == null) {
            Valor derecha = this.verValor(this.derecha,variablesGlobal);
            Valor izquierda = this.verValor(this.Izquierda,variablesGlobal);
            this.resultadoFinal = new OperadorToken(derecha,izquierda,this.tipo,this,variablesGlobal).operar();
        }
        return this.resultadoFinal;
    }

    private Valor verValor(Toke ver,ArrayList<Declaracion> variablesGlobal){
        if (ver instanceof Operacion) {
            Operacion verSegundo = (Operacion) ver;
            return verSegundo.getValor(variablesGlobal);
        }
        if (ver instanceof Valor) {
            Valor verSegundo = (Valor) ver;
            return verSegundo;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getValor(null).toString() + super.toString();
    }

}
