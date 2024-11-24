package com.livraria.livromais.service;

import com.livraria.livromais.model.Livro;
import com.livraria.livromais.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        Iterable<Livro> livrosIterable = livroRepository.findAll();
        return StreamSupport.stream(livrosIterable.spliterator(), false)
                            .collect(Collectors.toList());
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Livro com ID " + id + " não encontrado"));
    }

    @Transactional
    public void salvar(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("O título do livro não pode ser vazio");
        }
        livroRepository.save(livro);
    }

    @Transactional
    public void excluir(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new IllegalArgumentException("Livro com ID " + id + " não encontrado");
        }
        livroRepository.deleteById(id);
    }
}
