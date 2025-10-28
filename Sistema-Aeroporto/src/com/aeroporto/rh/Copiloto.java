package com.aeroporto.rh;

public class Copiloto extends Tripulante {
    private String licenca;

    public Copiloto(String nome, String documento, String numId, String licenca) {
        super(nome, documento, numId);
        if (licenca == null || licenca.trim().isEmpty()) {
            throw new IllegalArgumentException("Licença é obrigatória para Copiloto.");
        }
        this.licenca = licenca;
    }

    @Override
    public String anunciar() {
        return "Este é o Copiloto " + getNome() + ". Verificando os instrumentos de voo.";
    }
}
