package br.com.letscode;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João");
        pessoa1.setIdade(16);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Maria");
        pessoa2.setIdade(20);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Jorge");
        pessoa3.setIdade(17);

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Jessica");
        pessoa4.setIdade(20);

        Pessoa pessoa5 = new Pessoa();
        pessoa5.setNome("Carlos");
        pessoa5.setIdade(28);

        // TESTES:

        ListaDePessoas listaDePessoas = new ListaDePessoas();

        System.out.println("Teste void adicionar(Pessoa pessoa)");
        listaDePessoas.adicionar(pessoa1);
        listaDePessoas.listarTodos();

        System.out.println("Teste void adicionar(Pessoa pessoa)");
        listaDePessoas.adicionar(pessoa2);
        listaDePessoas.listarTodos();

        System.out.println("Teste void adicionar(int index, Pessoa pessoa)");
        listaDePessoas.adicionar(0,pessoa3);
        listaDePessoas.listarTodos();

        ListaDePessoas listaDePessoas2 = new ListaDePessoas();

        System.out.println("Teste void adicionar(Pessoa pessoa)");
        listaDePessoas2.adicionar(pessoa4); // Teste void adicionar(Pessoa pessoa)
        listaDePessoas2.listarTodos();

        System.out.println("Teste void adicionar(Pessoa pessoa)");
        listaDePessoas2.adicionar(pessoa5); // Teste void adicionar(Pessoa pessoa)
        listaDePessoas2.listarTodos();

        System.out.println("Teste Pessoa buscar(String nome)");
        System.out.println(listaDePessoas.buscar("Maria").getNome());
        System.out.println();

        System.out.println("Teste void adicionarTodos(ListaDePessoas listaDePessoas)");
        listaDePessoas.adicionarTodos(listaDePessoas2);
        listaDePessoas.listarTodos();

        System.out.println("Teste void remover(Pessoa pessoa)");
        listaDePessoas.remover(pessoa4);
        listaDePessoas.listarTodos();

        System.out.println("Teste void remover(int index);");
        listaDePessoas.remover(3);
        listaDePessoas.listarTodos();

        System.out.println("Teste Pessoa getPessoa(int index)");
        System.out.println(listaDePessoas.getPessoa(1).getNome());
        System.out.println();

        System.out.println("Teste int obterTamanho()");
        listaDePessoas.listarTodos();
        System.out.println();

        System.out.println("Teste int obterTamanho()");
        System.out.println(listaDePessoas.buscarPosicao("Maria"));
        System.out.println();

        System.out.println("Teste Pessoa[] toArray()");
        System.out.println( Arrays.toString(listaDePessoas.toArray()));
        System.out.println();

        System.out.println("Teste void adicionarTodos(ListaDePessoas listaDePessoas)");
        listaDePessoas.adicionarTodos(listaDePessoas2);
        listaDePessoas.listarTodos();

        System.out.println("Teste void removerTodos(ListaDePessoas listaDePessoas)");
        listaDePessoas.removerTodos(listaDePessoas2);
        listaDePessoas.listarTodos();

    }
}
