package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Categoria;
import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class LivrosController {

    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Autor> autores = new ArrayList<>();
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private int proximoId = 1;

    public LivrosController() {
        Autor machado = new Autor("Machado de Assis", "Brasileira");
        Categoria romance = new Categoria("Romance", "Literatura brasileira");
        autores.add(machado);
        categorias.add(romance);

        adicionarLivro("Dom Casmurro", machado, "978-85-00-00000-0", romance);
        adicionarLivro("Pequeno Gafanhoto", machado, "978-85-00-00001-7", romance);

        Usuario usuario = new Usuario("Grande Homem", "2026001", "Grande.Homem@email.com");
        usuarios.add(usuario);
        emprestimos.add(new Emprestimo(livros.get(1), usuario, "20/11/2026"));
    }

    private void adicionarLivro(String titulo, Autor autor, String isbn, Categoria categoria) {
        Livro livro = new Livro(proximoId, titulo, autor, isbn, categoria);
        proximoId++;
        livros.add(livro);
        autor.getObras().add(livro);
    }

    private Autor buscarAutor(String nome) {
        for (Autor a : autores) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        Autor novo = new Autor(nome, "");
        autores.add(novo);
        return novo;
    }

    private Categoria buscarCategoria(String nome) {
        for (Categoria c : categorias) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        Categoria nova = new Categoria(nome, "");
        categorias.add(nova);
        return nova;
    }

    @GetMapping("/")
    public String inicio() {
        return "livros/inicio";
    }

    @GetMapping("/livros")
    public String exibirLivros(Model model) {
        model.addAttribute("livros", livros);
        return "livros/livros";
    }

    @PostMapping("/livros/adicionar")
    public String salvarLivro(@RequestParam String titulo, @RequestParam String autor,
                              @RequestParam String isbn, @RequestParam String categoria) {
        adicionarLivro(titulo, buscarAutor(autor), isbn, buscarCategoria(categoria));
        return "redirect:/livros";
    }

    @PostMapping("/livros/remover")
    public String removerLivro(@RequestParam int id) {
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            if (livro.getId() == id) {
                livro.getAutor().getObras().remove(livro);
                livros.remove(i);
                break;
            }
        }
        return "redirect:/livros";
    }

    @GetMapping("/autores")
    public String exibirAutores(Model model) {
        model.addAttribute("autores", autores);
        return "livros/autores";
    }

    @GetMapping("/categorias")
    public String exibirCategorias(Model model) {
        model.addAttribute("categorias", categorias);
        return "livros/categorias";
    }

    @GetMapping("/usuarios")
    public String exibirUsuarios(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "livros/usuarios";
    }

    @GetMapping("/emprestimos")
    public String exibirEmprestimos(Model model) {
        model.addAttribute("emprestimos", emprestimos);
        return "livros/emprestimos";
    }
}
