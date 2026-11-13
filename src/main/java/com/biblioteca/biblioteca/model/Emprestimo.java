package com.biblioteca.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {

    private Long id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Livro livro, Usuario usuario) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
    }

    public void registrarRetirada() {
        if (!livro.isDisponivel()) {
            throw new IllegalStateException("Livro indisponível para empréstimo");
        }
        this.dataRetirada = LocalDate.now();
        livro.setDisponivel(false);
    }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDate.now();
        livro.setDisponivel(true);
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
