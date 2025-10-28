package com.aeroporto.aeronave;

import com.aeroporto.rh.Passageiro;

public class Assento {
    private String codigo;
    private boolean ocupado;
    private Passageiro passageiro;

    public Assento(String codigo) {
        this.codigo = codigo;
        this.ocupado = false;
    }

    public void atribuirPassageiro(Passageiro p) {
        if (ocupado) {
            throw new IllegalStateException("Assento " + codigo + " já está ocupado.");
        }
        this.passageiro = p;
        this.ocupado = true;
        System.out.println("Assento " + codigo + " ocupado por " + p.getNome());
    }

    public String getCodigo() { return codigo; }
    public boolean isOcupado() { return ocupado; }
    public Passageiro getPassageiro() { return passageiro; }
}