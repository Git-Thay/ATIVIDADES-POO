package com.aeroporto.rh;

public abstract class Tripulante extends Pessoa {
    private String numeroIdentificacao;

    public Tripulante(String nome, String documento, String numeroIdentificacao) {
        super(nome, documento);
        if (numeroIdentificacao == null || numeroIdentificacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Número de identificação é obrigatório.");
        }
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public String getNumeroIdentificacao() { return numeroIdentificacao; }
}
