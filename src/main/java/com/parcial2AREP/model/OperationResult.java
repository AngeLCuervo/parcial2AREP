package com.parcial2AREP.model;

public class OperationResult {

    private String tipoOperacion;
    private int valorEntrada;
    private String resultado;

    public OperationResult(String tipoOperacion, int valorEntrada, String resultado) {
        this.tipoOperacion = tipoOperacion;
        this.valorEntrada = valorEntrada;
        this.resultado = resultado;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public int getValorEntrada() {
        return valorEntrada;
    }

    public String getResultado() {
        return resultado;
    }
}
