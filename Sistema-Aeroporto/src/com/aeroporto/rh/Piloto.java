package com.aeroporto.rh;

public class Piloto extends Tripulante {
    private String licenca;

    public Piloto(String nome, String documento, String numId, String licenca) {
        super(nome, documento, numId);
        if (licenca == null || licenca.trim().isEmpty()) {
            throw new IllegalArgumentException("Licença é obrigatória para Piloto.");
        }
        this.licenca = licenca;
    }

    @Override
    public String anunciar() {
        return "Atenção, aqui é o Piloto " + getNome() + " falando. Preparamos para a decolagem.";
    }
}
