package com.biblioteca.biblioteca.model;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private String dataRetirada;
    private String dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, Usuario usuario, String dataRetirada) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataRetirada = dataRetirada;
        livro.setDisponivel(false);
    }

    public void devolver(String data) {
        dataDevolucao = data;
        livro.setDisponivel(true);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
