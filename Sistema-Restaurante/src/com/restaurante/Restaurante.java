import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Classe principal Restaurante, que agrupa todas as entidades.
 */
public class Restaurante {
    private String nome;
    private String endereco;

    // Associações
    // Associação 1:1 com Cardápio
    private Cardapio cardapio;
    // Associação 1..* com Região
    private List<Regiao> regioes;
    // Lista de todos os pedidos, para controle
    private List<Pedido> pedidos;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.cardapio = new Cardapio();
        this.regioes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void adicionarRegiao(Regiao regiao) {
        this.regioes.add(regiao);
    }

    public void registrarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        System.out.println("-> Pedido #" + pedido.getIdPedido() + " registrado com sucesso!");
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public Cardapio getCardapio() { return cardapio; }
    public List<Regiao> getRegioes() { return regioes; }
    public List<Pedido> getPedidos() { return pedidos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setCardapio(Cardapio cardapio) { this.cardapio = cardapio; }

    @Override
    public String toString() {
        return "Restaurante: " + nome + " | Endereço: " + endereco;
    }

    // --- MAIN APP PARA DEMONSTRAÇÃO DE USO ---
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante("Sabor POO", "Av. Principal, 123");

        System.out.println("--- 1. CONFIGURAÇÃO INICIAL DO RESTAURANTE ---");
        System.out.println(restaurante);

        // 1.1. Configuração do Cardápio
        restaurante.getCardapio().adicionarPrato(new Prato("Feijoada Completa", 35.50, Arrays.asList(DiaSemana.SEXTA, DiaSemana.SABADO)));
        restaurante.getCardapio().adicionarPrato(new Prato("Frango Grelhado", 28.00, Arrays.asList(DiaSemana.values())));
        Prato pratoBolo = new Prato("Bolo de Chocolate", 12.00, Arrays.asList(DiaSemana.values()));
        restaurante.getCardapio().adicionarPrato(pratoBolo);
        System.out.println(restaurante.getCardapio());

        // 1.2. Configuração de Regiões e Garçons
        Regiao regiaoA = new Regiao("Salão Principal");
        Regiao regiaoB = new Regiao("Área Externa");

        Garcom garcom1 = new Garcom("João Silva", "G-001", regiaoA);
        Garcom garcom2 = new Garcom("Maria Souza", "G-002", regiaoA);
        Garcom garcom3 = new Garcom("Pedro Lima", "G-003", regiaoB);

        regiaoA.adicionarGarcom(garcom1);
        regiaoA.adicionarGarcom(garcom2);
        regiaoB.adicionarGarcom(garcom3);
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

        // PEDIDO 1: IMEDIATO na MESA (atendido por Garçom)
        Pedido pedido1 = new Pedido(cli2, garcom1, LocalAtendimento.MESA);
        pedido1.adicionarItem(restaurante.getCardapio().buscarPratoPorNome("Frango Grelhado").get(), 1);
        pedido1.adicionarItem(pratoBolo, 1);

        restaurante.registrarPedido(pedido1);

        System.out.println("\nDETALHES DO PEDIDO #" + pedido1.getIdPedido());
        System.out.println("Atendente: " + pedido1.getAtendente().getNome());
        System.out.println("Tipo: " + pedido1.getTipoAtendimento());
        System.out.println("Local: " + pedido1.getLocalAtendimento());
        System.out.println("Total: R$ " + String.format("%.2f", pedido1.calcularValorTotal()));

        // PEDIDO 2: AGENDADO para DOMICÍLIO (coletado por Telefonista)
        LocalDateTime horaEntrega = LocalDateTime.now().plusHours(2);
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