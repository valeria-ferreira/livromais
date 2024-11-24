package com.livraria.livromais.repository;

import com.livraria.livromais.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  
public interface LivroRepository extends CrudRepository<Livro, Long> {
}
