package com.restaurante.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Pedido, que agrega todos os detalhes de uma transação.
 */
public class Pedido {
    private static int proximoId = 1;
    private int idPedido;
    private LocalDateTime dataHora;
    private TipoAtendimento tipoAtendimento;
    private LocalDateTime dataHoraEntrega; // Para AGENDADO
    private LocalAtendimento localAtendimento; // MESA ou DOMICILIO

    // Associações
    // Associação 1:1 com Cliente
    private Cliente cliente;
    // Associação 1:1 com Garçom/Telefonista (usando a classe base Funcionario)
    private Funcionario atendente;
    // Associação 1..* com ItemPedido (composição)
    private List<ItemPedido> itens;

    public Pedido(Cliente cliente, Funcionario atendente, TipoAtendimento tipoAtendimento, LocalAtendimento localAtendimento, LocalDateTime dataHoraEntrega) {
        this.idPedido = proximoId++;
        this.dataHora = LocalDateTime.now();
        this.cliente = cliente;
        this.atendente = atendente;
        this.tipoAtendimento = tipoAtendimento;
        this.localAtendimento = localAtendimento;
        this.dataHoraEntrega = dataHoraEntrega;
        this.itens = new ArrayList<>();
    }

    /**
     * Construtor simplificado para pedidos IMEDIATOS.
     */
    public Pedido(Cliente cliente, Funcionario atendente, LocalAtendimento localAtendimento) {
        this(cliente, atendente, TipoAtendimento.IMEDIATO, localAtendimento, null);
    }

    public void adicionarItem(Prato prato, int quantidade) {
        this.itens.add(new ItemPedido(prato, quantidade));
    }

    public double calcularValorTotal() {
        return this.itens.stream().mapToDouble(ItemPedido::calcularSubtotal).sum();
    }

    // Getters
    public int getIdPedido() { return idPedido; }
    public LocalDateTime getDataHora() { return dataHora; }
    public TipoAtendimento getTipoAtendimento() { return tipoAtendimento; }
    public LocalDateTime getDataHoraEntrega() { return dataHoraEntrega; }
    public LocalAtendimento getLocalAtendimento() { return localAtendimento; }
    public Cliente getCliente() { return cliente; }
    public Funcionario getAtendente() { return atendente; }
    public List<ItemPedido> getItens() { return itens; }

    // Setters
    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) { this.tipoAtendimento = tipoAtendimento; }
    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) { this.dataHoraEntrega = dataHoraEntrega; }
    public void setLocalAtendimento(LocalAtendimento localAtendimento) { this.localAtendimento = localAtendimento; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setAtendente(Funcionario atendente) { this.atendente = atendente; }
}
