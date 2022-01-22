package br.com.letscode;

import br.com.letscode.Pessoa;

public interface EstruturaDados {
    void adicionar(Pessoa pessoa);
    void adicionar(int index, Pessoa pessoa);
    Pessoa buscar(String nome);
    void remover(Pessoa pessoa);
    void remover(int index);
    void listarTodos();
    Pessoa getPessoa(int index);
    int obterTamanho();
    void adicionarTodos(ListaDePessoas listaDePessoas);
    int buscarPosicao(String nome);
    Pessoa[] toArray();
    void removerTodos(ListaDePessoas listaDePessoas);
}
