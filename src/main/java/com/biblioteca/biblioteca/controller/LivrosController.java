package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Categoria;
import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LivrosController {

    private final Autor autor = new Autor(1L, "Machado de Assis", "Brasileira");
    private final Categoria categoria = new Categoria(1L, "Romance", "Literatura brasileira");
    private final Livro livro = new Livro(1L, "Dom Casmurro", autor, "978-85-00-00000-0", categoria);
    private final Usuario usuario = new Usuario(1L, "Grande Homem", "2026001", "Grande.Homem@email.com");

    public LivrosController() {
        autor.adicionarObra(livro);
    }

    @GetMapping("/")
    public String inicio() {
        return "livros/inicio";
    }

    @GetMapping("/livros")
    public String exibirLivros(Model model) {
        model.addAttribute("livros", List.of(livro));
        return "livros/livros";
    }

    @GetMapping("/autores")
    public String exibirAutores(Model model) {
        model.addAttribute("autores", List.of(autor));
        return "livros/autores";
    }

    @GetMapping("/categorias")
    public String exibirCategorias(Model model) {
        model.addAttribute("categorias", List.of(categoria));
        return "livros/categorias";
    }

    @GetMapping("/usuarios")
    public String exibirUsuarios(Model model) {
        model.addAttribute("usuarios", List.of(usuario));
        return "livros/usuarios";
    }

    @GetMapping("/emprestimos")
    public String exibirEmprestimos(Model model) {
        Emprestimo emprestimo = new Emprestimo(1L, new Livro(2L, "Pequeno Gafanhoto", autor, "978-85-00-00001-7", categoria), usuario);
        emprestimo.registrarRetirada();
        model.addAttribute("emprestimos", List.of(emprestimo));
        return "livros/emprestimos";
    }
}
