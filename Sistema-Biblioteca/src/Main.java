// -*- coding: UTF-8 -*-
public class Main {
    public static void main(String[] args) {
        // Criando uma instancia da classe Livro
        Livro livro1 = new Livro("O Senhor dos Aneis", "J.R.R. Tolkien", "123456789");

        // Exibindo informacoes do livro
        System.out.println("=== Informacoes do Livro ===");
        livro1.exibirInformacoes();

        System.out.println("\n=== Testando Emprestimo ===");
        livro1.emprestarLivro();   // Deve emprestar com sucesso
        livro1.emprestarLivro();   // Deve informar que ja esta emprestado

        System.out.println("\n=== Testando Devolucao ===");
        livro1.devolverLivro();    // Deve devolver com sucesso
        livro1.exibirInformacoes(); // Agora disponivel novamente
    }
}

// ==========================
// Classe Livro
// ==========================
class Livro {
    // Atributos privados (Encapsulamento)
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    // Construtor
    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true; // Quando o livro e criado, esta disponivel
    }

    // Metodos de acesso (Getters)
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Metodo para emprestar o livro
    public void emprestarLivro() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Emprestimo realizado com sucesso: \"" + titulo + "\"");
        } else {
            System.out.println("O livro \"" + titulo + "\" ja esta emprestado.");
        }
    }

    // Metodo para devolver o livro
    public void devolverLivro() {
        disponivel = true;
        System.out.println("Livro \"" + titulo + "\" devolvido com sucesso!");
    }

    // Metodo para exibir as informacoes do livro
    public void exibirInformacoes() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Disponivel: " + (disponivel ? "Sim" : "Nao"));
    }
}
