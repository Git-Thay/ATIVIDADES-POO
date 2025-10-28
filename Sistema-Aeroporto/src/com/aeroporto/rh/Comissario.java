package com.aeroporto.rh;

public class Comissario extends Tripulante {

    public Comissario(String nome, String documento, String numId) {
        super(nome, documento, numId);
    }

    @Override
    public String anunciar() {
        return "Bem-vindos a bordo. Sou o Comissário(a) " + getNome() + ".";
    }
}