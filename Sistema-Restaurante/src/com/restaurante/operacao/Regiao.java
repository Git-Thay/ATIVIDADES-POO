package com.restaurante.operacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Regiao, que define um conjunto de garçons que a servem.
 * Associado a Restaurante (1..*) e a Garcom (1..*).
 */
public class Regiao {
    private String nome;
    // Associação: Uma Região é servida por múltiplos Garçons.
    private List<Garcom> garcons;

    public Regiao(String nome) {
        this.nome = nome;
        this.garcons = new ArrayList<>();
    }

    // Método para adicionar um Garçom
    public void adicionarGarcom(Garcom garcom) {
        // Garçom deve ser associado à região no momento da criação/adição
        if (garcom.getRegiao() != this) {
            garcom.setRegiao(this);
        }
        this.garcons.add(garcom);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Garcom> getGarcons() {
        return garcons;
    }

    @Override
    public String toString() {
        return "Região: " + nome + " (" + garcons.size() + " garçons)";
    }
}
