package com.projeto.servicoviajem.model;

import java.math.BigDecimal;

public class Pacote {
    private final String local;
    private final String imagem;
    private final  int dias;
    private final BigDecimal valor;

    public Pacote(String local, String imagem, int dias, BigDecimal valor) {
        this.local = local;
        this.imagem = imagem;
        this.dias = dias;
        this.valor = valor;
    }
    public String getLocal(){
        return local;
    }

    public String getImagem() {
        return imagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getDias() {
        return dias;
    }
}
