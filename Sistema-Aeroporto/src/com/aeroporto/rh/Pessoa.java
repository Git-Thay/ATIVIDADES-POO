package com.aeroporto.rh;

public abstract class Pessoa {
    private String nome;
    private String documento;

    public Pessoa(String nome, String documento) {
        if (nome == null || documento == null || nome.trim().isEmpty() || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e documento são obrigatórios.");
        }
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() { return nome; }
    public String getDocumento() { return documento; }

    public abstract String anunciar();
}