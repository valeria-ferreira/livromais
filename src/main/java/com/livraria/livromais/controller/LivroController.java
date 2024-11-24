package com.livraria.livromais.controller;

import com.livraria.livromais.service.LivroService;
import com.livraria.livromais.model.Livro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    // Exibir a lista de livros
    @GetMapping
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroService.listarTodos());
        model.addAttribute("novoLivro", new Livro());
        return "livros";
    }

    // Adicionar um novo livro
    @PostMapping
    public String adicionarLivro(@ModelAttribute Livro livro) {
        livroService.salvar(livro);
        return "redirect:/livros";
    }

    // Editar livro existente
    @GetMapping("/{id}/editar")
    public String editarLivro(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarPorId(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
            return "editar-livro";
        }
        return "redirect:/livros";
    }

    // Atualizando livro editado
    @PostMapping("/{id}/editar")
    public String atualizarLivro(@PathVariable Long id, @ModelAttribute Livro livroAtualizado, Model model) {
        Livro livro = livroService.buscarPorId(id);
        if (livro != null) {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setCategoria(livroAtualizado.getCategoria());
            livro.setNota(livroAtualizado.getNota());
            livro.setComentario(livroAtualizado.getComentario());

            // Salvndo as alterações no banco de dados
            livroService.salvar(livro);

            model.addAttribute("mensagem", "Livro atualizado com sucesso!");
            return "redirect:/livros";
        } else {
            model.addAttribute("erro", "Livro não encontrado!");
            return "redirect:/livros";  
        }
    }

    // Excluir livro
    @PostMapping("/{id}/excluir")
    public String excluirLivro(@PathVariable Long id) {
        livroService.excluir(id);
        return "redirect:/livros";
    }
}
