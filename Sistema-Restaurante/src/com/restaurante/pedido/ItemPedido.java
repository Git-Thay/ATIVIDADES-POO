package com.restaurante.pedido;

/**
 * Classe ItemPedido, detalhe da composição do Pedido.
 * Associa um Prato e a quantidade desejada.
 */
public class ItemPedido {
    private int quantidade;
    // Associação 1:1 com Prato
    private Prato prato;

    public ItemPedido(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }

    // Método de cálculo
    public double calcularSubtotal() {
        return prato.getPreco() * quantidade;
    }

    // Getters e Setters
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    @Override
    public String toString() {
        return quantidade + "x " + prato.getNome() + " (Subtotal: R$ " + String.format("%.2f", calcularSubtotal()) + ")";
    }
}