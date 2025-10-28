package com.aeroporto.operacao;

import com.aeroporto.voo.Voo;

public class Pouso implements OperacaoVoo {
    @Override
    public void executarOperacao(Voo voo) {
        System.out.println("\n--- Pouso em curso ---");
        voo.alterarStatus("EM_APROXIMACAO");
        voo.alterarStatus("POUSADO");
        System.out.println("Voo " + voo.getCodigo() + " pousou.");
    }
}