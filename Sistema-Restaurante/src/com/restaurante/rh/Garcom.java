package com.restaurante.rh;

/**
 * Classe Garcom, que herda de Funcionario.
 * Associado a uma Região.
 */
public class Garcom extends Funcionario {
    // Associação: um Garçom atende a uma Região.
    private Regiao regiao;

    public Garcom(String nome, String matricula, Regiao regiao) {
        super(nome, matricula);
        this.regiao = regiao;
    }

    // Getter e Setter
    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "Garçom: " + getNome() + " (Matrícula: " + getMatricula() + ")";
    }
}