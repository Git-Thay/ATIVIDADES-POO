import com.restaurante.rh.*;
import com.restaurante.pedido.*;
import com.restaurante.cardapio.*;
import com.restaurante.operacao.*;

import java.time.LocalDateTime;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // Inicializa o Restaurante
        Restaurante restaurante = new Restaurante("Sabor POO", "Av. Principal, 123");

        System.out.println("--- 1. CONFIGURAÇÃO INICIAL DO RESTAURANTE ---");
        System.out.println(restaurante);

        // 1.1. Configuração do Cardápio (Criação de Pratos)
        // Note o uso do enum DiaSemana
        restaurante.getCardapio().adicionarPrato(new Prato("Feijoada Completa", 35.50, Arrays.asList(DiaSemana.SEXTA, DiaSemana.SABADO)));
        restaurante.getCardapio().adicionarPrato(new Prato("Frango Grelhado", 28.00, Arrays.asList(DiaSemana.values())));
        Prato pratoBolo = new Prato("Bolo de Chocolate", 12.00, Arrays.asList(DiaSemana.values()));
        restaurante.getCardapio().adicionarPrato(pratoBolo);
        System.out.println(restaurante.getCardapio());

        // 1.2. Configuração de Regiões e Garçons
        Regiao regiaoA = new Regiao("Salão Principal");
        Regiao regiaoB = new Regiao("Área Externa");

        // Os Garçons são criados já associados a uma Região
        Garcom garcom1 = new Garcom("João Silva", "G-001", regiaoA);
        Garcom garcom2 = new Garcom("Maria Souza", "G-002", regiaoA);
        Garcom garcom3 = new Garcom("Pedro Lima", "G-003", regiaoB);

        // Adiciona os garçons às suas respectivas regiões (a Regiao os associa)
        regiaoA.adicionarGarcom(garcom1);
        regiaoA.adicionarGarcom(garcom2);
        regiaoB.adicionarGarcom(garcom3);

        // Adiciona as regiões ao restaurante
        restaurante.adicionarRegiao(regiaoA);
        restaurante.adicionarRegiao(regiaoB);

        Telefonista tel1 = new Telefonista("Ana Paula", "T-001");

        System.out.println(regiaoA);
        System.out.println(regiaoB);
        System.out.println(tel1);

        // 1.3. Clientes
        Cliente cli1 = new Cliente("Carlos Mendes", "(62) 9999-0000", "Rua A, 100, Centro");
        Cliente cli2 = new Cliente("Juliana Costa", "(62) 8888-1111", "Mesa 5");

        System.out.println("\n--- 2. REGISTRO DE PEDIDOS ---");

        // PEDIDO 1: IMEDIATO na MESA (Atendido por Garçom, localAtendimento é MESA)
        // Uso do construtor simplificado para pedidos imediatos
        Pedido pedido1 = new Pedido(cli2, garcom1, LocalAtendimento.MESA);
        // Busca os pratos e adiciona os itens
        pedido1.adicionarItem(restaurante.getCardapio().buscarPratoPorNome("Frango Grelhado").get(), 1);
        pedido1.adicionarItem(pratoBolo, 1);

        restaurante.registrarPedido(pedido1);

        System.out.println("\nDETALHES DO PEDIDO #" + pedido1.getIdPedido());
        System.out.println("Atendente: " + pedido1.getAtendente().getNome());
        System.out.println("Tipo: " + pedido1.getTipoAtendimento());
        System.out.println("Local: " + pedido1.getLocalAtendimento());
        System.out.println("Total: R$ " + String.format("%.2f", pedido1.calcularValorTotal()));

        // PEDIDO 2: AGENDADO para DOMICÍLIO (Coletado por Telefonista)
        LocalDateTime horaEntrega = LocalDateTime.now().plusHours(2);
        // Uso do construtor completo para pedidos agendados
        Pedido pedido2 = new Pedido(cli1, tel1, TipoAtendimento.AGENDADO, LocalAtendimento.DOMICILIO, horaEntrega);
        pedido2.adicionarItem(restaurante.getCardapio().buscarPratoPorNome("Feijoada Completa").get(), 2);

        restaurante.registrarPedido(pedido2);

        System.out.println("\nDETALHES DO PEDIDO #" + pedido2.getIdPedido());
        System.out.println("Atendente: " + pedido2.getAtendente().getNome());
        System.out.println("Tipo: " + pedido2.getTipoAtendimento());
        System.out.println("Local: " + pedido2.getLocalAtendimento());
        System.out.println("Entrega Agendada para: " + horaEntrega.toLocalTime());
        System.out.println("Total: R$ " + String.format("%.2f", pedido2.calcularValorTotal()));

        System.out.println("\n--- 3. RELATÓRIO ---");
        System.out.println("Total de Pedidos no sistema: " + restaurante.getPedidos().size());
    }
}