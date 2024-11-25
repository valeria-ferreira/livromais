package com.livraria.livromais.repository;

import com.livraria.livromais.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    // Método para buscar livros pelo título
    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    // Método para buscar livros pelo autor
    List<Livro> findByAutorContainingIgnoreCase(String autor);

    // Método para buscar livros por categoria
    List<Livro> findByCategoriaContainingIgnoreCase(String categoria);

    // Método para buscar livros com uma nota maior ou igual a um valor específico
    List<Livro> findByNotaGreaterThanEqual(Integer nota);

    // Método para buscar livros por comentário (pesquisa por palavras chave dentro do comentário)
    List<Livro> findByComentarioContainingIgnoreCase(String comentario);

    // Método para buscar livros ordenados por título
    List<Livro> findAllByOrderByTituloAsc();
}