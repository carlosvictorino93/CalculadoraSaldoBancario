package br.com.letscode;

import br.com.letscode.EstruturaDados;

public class ListaDePessoas implements EstruturaDados {

    private Pessoa[] pessoas;
    private int index = 0;

    @Override
    public void adicionar(Pessoa pessoa) {
        Pessoa[] pessoas = new Pessoa[this.index + 1];
        int indexNew = 0;
        if (this.index != 0) {
            for (int i = 0; i < this.index; i++) {
                pessoas[indexNew] = this.pessoas[i];
                indexNew++;
            }
        }
        pessoas[indexNew] = pessoa;
        indexNew++;
        this.pessoas = pessoas;
        this.index = indexNew;
    }

    @Override
    public void adicionar(int index, Pessoa pessoa) {
        Pessoa[] pessoas = new Pessoa[this.index + 1];
        int indexNew = 0;

        for (int i = 0; i < this.index; i++) {
            if (i == index) {
                pessoas[indexNew] = pessoa;
                indexNew++;
            }
            pessoas[indexNew] = this.pessoas[i];
            indexNew++;
        }
        this.pessoas = pessoas;
        this.index = indexNew;
    }

    @Override
    public void adicionarTodos(ListaDePessoas listaDePessoas) {
        int tamanhoLista  = listaDePessoas.obterTamanho();
        int indexNew = 0;
        Pessoa[] pessoas = new Pessoa[this.index + tamanhoLista];

        for (int i = 0; i < this.index; i++) {
            pessoas[indexNew] = this.pessoas[i];
            indexNew++;
        }

        Pessoa[] listaPessoas = listaDePessoas.toArray();
        for (int i = 0; i < tamanhoLista; i++) {
            pessoas[indexNew] = listaPessoas[i];
            indexNew++;
        }
        this.pessoas = pessoas;
        this.index = indexNew;
    }

    @Override
    public Pessoa buscar(String nome)  {
        for (int i = 0; i < this.index; i++) {
            if (this.pessoas[i].getNome() == nome) return this.pessoas[i];
        }
        throw new RuntimeException("Not Found");
    }

    @Override
    public int buscarPosicao(String nome) {
        for (int i = 0; i < this.index; i++) {
            if (this.pessoas[i].getNome() == nome) return i;
        }
        throw new RuntimeException("Not Found");
    }

    @Override
    public void remover(Pessoa pessoa) {
        Pessoa[] pessoas = new Pessoa[this.index];
        int index = 0;
        for (int i = 0; i < this.index; i++) {
            if (this.pessoas[i].getNome() != pessoa.getNome() || this.pessoas[i].getIdade() != pessoa.getIdade()) {
                pessoas[index] = this.pessoas[i];
                index++;
            }
        }
        this.pessoas = pessoas;
        this.index = index;
    }

    @Override
    public void remover(int index) {
        Pessoa[] pessoas = new Pessoa[this.index];
        int index1 = 0;
        for (int i = 0; i < this.index; i++) {
            if (i != index) {
                pessoas[index1] = this.pessoas[i];
                index1++;
            }
        }
        this.pessoas = pessoas;
        this.index = index1;
    }

    @Override
    public void removerTodos(ListaDePessoas listaDePessoas) {
        Pessoa[] listaPessoas = listaDePessoas.toArray();
        for (int i = 0; i < listaDePessoas.obterTamanho(); i++) {
            remover(listaPessoas[i]);
        }
    }

    @Override
    public void listarTodos() {
        for (int i = 0; i < this.index; i++) {
            System.out.println(this.pessoas[i].getNome());
        }
        System.out.println();
    }

    @Override
    public Pessoa[] toArray() {
        return this.pessoas;
    }

    @Override
    public Pessoa getPessoa(int index) {
        return this.pessoas[index];
    }

    @Override
    public int obterTamanho() {
        return this.index;
    }
}
