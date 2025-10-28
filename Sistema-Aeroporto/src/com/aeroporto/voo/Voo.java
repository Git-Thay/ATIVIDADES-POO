package com.aeroporto.voo;

import com.aeroporto.aeronave.Aviao;
import com.aeroporto.aeronave.Assento;
import com.aeroporto.operacao.OperacaoVoo;
import com.aeroporto.rh.Passageiro;
import com.aeroporto.rh.Tripulante;
import java.util.*;

public class Voo {
    private String codigo;
    private String status;
    private Aviao aviao;
    private List<Tripulante> tripulantes;
    private List<Passageiro> passageiros;

    private OperacaoVoo operacaoEstrategia;

    public Voo(String codigo, Aviao aviao) {
        this.codigo = codigo;
        this.aviao = aviao;
        this.status = "PLANEJADO";
        this.tripulantes = new ArrayList<>();
        this.passageiros = new ArrayList<>();
    }

    public void alocarTripulante(Tripulante t) {
        if (t != null) {
            tripulantes.add(t);
            aviao.alocarTripulante(t);
        }
    }

    public void atribuirAssento(Passageiro p, String codigoAssento) {
        Assento assento = aviao.getAssentoPorCodigo(codigoAssento);
        try {
            if (assento != null) {
                assento.atribuirPassageiro(p);
                passageiros.add(p);
                p.embarcar();
            } else {
                System.out.println("Erro: Assento " + codigoAssento + " não existe.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void alterarStatus(String novoStatus) {
        this.status = novoStatus;
        System.out.println("Status do Voo " + codigo + " alterado para: " + novoStatus);
    }

    public void setOperacaoEstrategia(OperacaoVoo estrategia) {
        this.operacaoEstrategia = estrategia;
    }

    public void executarOperacao() {
        if (operacaoEstrategia != null) {
            operacaoEstrategia.executarOperacao(this);
        } else {
            System.out.println("Nenhuma estratégia de operação definida.");
        }
    }

    public String getCodigo() { return codigo; }

    public void imprimirAnunciosPolimorficos() {
        System.out.println("\n--- Anúncios da Tripulação ---");
        tripulantes.forEach(t -> System.out.println(t.anunciar()));
    }
}