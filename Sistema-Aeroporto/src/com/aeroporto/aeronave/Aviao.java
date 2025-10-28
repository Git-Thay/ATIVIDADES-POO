package com.aeroporto.aeronave;

import com.aeroporto.rh.Tripulante;
import java.util.*;

public class Aviao {
    private String codigo;
    private List<Assento> assentos;
    private List<Tripulante> tripulacao;

    public Aviao(String codigo, int capacidade) {
        this.codigo = codigo;
        this.assentos = new ArrayList<>();
        this.tripulacao = new ArrayList<>();
        for (int i = 1; i <= capacidade; i++) {
            assentos.add(new Assento("A" + i));
        }
        System.out.println("Avião " + codigo + " criado com " + capacidade + " assentos.");
    }

    public Assento getAssentoPorCodigo(String codigo) {
        return assentos.stream()
                .filter(a -> a.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public void alocarTripulante(Tripulante t) {
        if (t == null) return;
        this.tripulacao.add(t);
        System.out.println("Tripulante " + t.getNome() + " alocado no Avião " + codigo);
    }

    public String getCodigo() { return codigo; }
    public List<Assento> getAssentos() { return assentos; }
    public List<Tripulante> getTripulacao() { return tripulacao; }
}