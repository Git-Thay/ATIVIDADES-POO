import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe Cardapio, que contém a lista de Pratos disponíveis.
 */
public class Cardapio {
    private LocalDateTime dataAtualizacao;
    // Associação 1..* com Prato
    private List<Prato> pratos;

    public Cardapio() {
        this.dataAtualizacao = LocalDateTime.now();
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        this.pratos.add(prato);
        this.dataAtualizacao = LocalDateTime.now(); // Atualiza data de atualização
    }

    public Optional<Prato> buscarPratoPorNome(String nome) {
        return pratos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    // Getters e Setters
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Cardápio (Atualizado em: " + dataAtualizacao.toLocalDate() + ") com " + pratos.size() + " pratos.";
    }
}
