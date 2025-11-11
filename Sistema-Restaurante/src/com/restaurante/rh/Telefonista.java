package com.restaurante.rh;

/**
 * Classe Telefonista, que herda de Funcionario.
 */
public class Telefonista extends Funcionario {
    public Telefonista(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public String toString() {
        return "Telefonista: " + getNome() + " (Matrícula: " + getMatricula() + ")";
    }
}
