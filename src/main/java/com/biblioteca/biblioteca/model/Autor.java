package com.biblioteca.biblioteca.model;

import java.util.ArrayList;

public class Autor {

    private String nome;
    private String nacionalidade;
    private ArrayList<Livro> obras = new ArrayList<>();

    public Autor() {
    }

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public ArrayList<Livro> getObras() {
        return obras;
    }

    public void setObras(ArrayList<Livro> obras) {
        this.obras = obras;
    }
}
