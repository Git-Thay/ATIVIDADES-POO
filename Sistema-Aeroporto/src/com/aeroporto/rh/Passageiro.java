package com.aeroporto.rh;

public class Passageiro extends Pessoa {
    private String passaporte;

    public Passageiro(String nome, String documento, String passaporte) {
        super(nome, documento);
        this.passaporte = passaporte;
    }

    public void embarcar() { System.out.println(getNome() + " está embarcando."); }
    public void desembarcar() { System.out.println(getNome() + " está desembarcando."); }

    @Override
    public String anunciar() {
        return "Passageiro " + getNome() + " a bordo, pronto para decolar.";
    }
}