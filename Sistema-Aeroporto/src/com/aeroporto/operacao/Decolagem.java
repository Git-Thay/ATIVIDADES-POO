package com.aeroporto.operacao;

import com.aeroporto.voo.Voo;

public class Decolagem implements OperacaoVoo {
    @Override
    public void executarOperacao(Voo voo) {
        System.out.println("\n--- Decolagem em curso ---");
        voo.alterarStatus("TAXINANDO");
        voo.alterarStatus("DECOLADO");
        System.out.println("Voo " + voo.getCodigo() + " decolou.");
    }
}