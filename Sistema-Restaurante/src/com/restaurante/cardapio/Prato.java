package com.restaurante.cardapio;

import java.util.List;

/**
 * Classe Prato, parte do Cardápio.
 * Contém o preço e os dias em que está disponível.
 */
public class Prato {
    private String nome;
    private double preco;
    // Uso de List<DiaSemana> para permitir que o prato esteja disponível em múltiplos dias
    private List<DiaSemana> diasDisponiveis;

    public Prato(String nome, double preco, List<DiaSemana> diasDisponiveis) {
        this.nome = nome;
        this.preco = preco;
        this.diasDisponiveis = diasDisponiveis;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<DiaSemana> getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public void setDiasDisponiveis(List<DiaSemana> diasDisponiveis) {
        this.diasDisponiveis = diasDisponiveis;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + String.format("%.2f", preco) + ")";
    }
}