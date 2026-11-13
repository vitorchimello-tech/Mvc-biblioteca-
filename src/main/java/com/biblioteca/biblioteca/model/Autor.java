package com.biblioteca.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private Long id;
    private String nome;
    private String nacionalidade;
    private List<Livro> obrasPublicadas = new ArrayList<>();

    public Autor() {
    }

    public Autor(Long id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Livro> getObrasPublicadas() {
        return obrasPublicadas;
    }

    public void setObrasPublicadas(List<Livro> obrasPublicadas) {
        this.obrasPublicadas = obrasPublicadas;
    }

    public void adicionarObra(Livro livro) {
        obrasPublicadas.add(livro);
    }
}
