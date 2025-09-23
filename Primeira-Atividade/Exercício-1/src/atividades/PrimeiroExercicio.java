package atividades;

public class PrimeiroExercicio {
    public static void main(String[] args) {

        String nome = "Maria de Souza";
        String produtoUm = "Computador";
        String produtoDois = "Relógio";
        
        int idade = 28;
        int codigo = 1234;

        char sexo = 'F';

        double precoUm = 5900.18;
        double precoDois= 415.25;
        double soma = precoUm + precoDois;

       System.out.println("*** Dados do Comprador ***");
       System.out.printf("Nome: %s \nIdade: %d \nCódigo: %d \nSexo: %s \n\n", nome, idade, codigo, sexo);

       System.out.println("*** Lista de Produtos ***");
       System.out.printf("Produto 1: %s | Preço: %.2f%nProduto 2: %s | Preço: %.2f%n \n", produtoUm, precoUm, produtoDois, precoDois);

       System.out.println("*** Valor total das Compras *** ");
       System.out.println("R$ "+soma);
       System.out.println();

    }
}

