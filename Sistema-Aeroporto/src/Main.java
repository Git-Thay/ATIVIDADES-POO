import com.aeroporto.aeronave.Aviao;
import com.aeroporto.operacao.Decolagem;
import com.aeroporto.operacao.Pouso;
import com.aeroporto.rh.*;
import com.aeroporto.voo.Voo;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. Cria Avião e Assentos ---");
        Aviao a747 = new Aviao("PR-GOL", 4);

        System.out.println("\n--- 2. Cria Voo ---");
        Voo voo500 = new Voo("VOO500", a747);

        System.out.println("\n--- 3. Aloca Tripulação ---");
        Piloto p = new Piloto("Cap. Alberto", "RG123", "P001", "ANAC-P1");
        Copiloto cp = new Copiloto("1o Oficial Bianca", "RG456", "CP02", "ANAC-C1");
        Comissario c1 = new Comissario("Ate. Carla", "RG789", "C003");

        voo500.alocarTripulante(p);
        voo500.alocarTripulante(cp);
        voo500.alocarTripulante(c1);

        System.out.println("\n--- 4. Embarca Passageiros ---");
        Passageiro pass1 = new Passageiro("Eduardo Castro", "CPF111", "PAS111");
        Passageiro pass2 = new Passageiro("Fernanda Alves", "CPF222", "PAS222");

        voo500.atribuirAssento(pass1, "A1");
        voo500.atribuirAssento(pass2, "A4");

        voo500.atribuirAssento(pass1, "A4");

        System.out.println("\n--- 5. Percorre Estados do Voo ---");

        voo500.alterarStatus("EM_SOLO");

        voo500.setOperacaoEstrategia(new Decolagem());
        voo500.executarOperacao();

        voo500.alterarStatus("EM_ROTA");

        voo500.setOperacaoEstrategia(new Pouso());
        voo500.executarOperacao();

        System.out.println("\n--- 6. Imprime Anúncios Polimórficos ---");
        voo500.imprimirAnunciosPolimorficos();
        System.out.println(pass1.anunciar());
    }
}