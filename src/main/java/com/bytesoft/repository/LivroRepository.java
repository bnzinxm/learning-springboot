package com.bytesoft.repository;

import com.bytesoft.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // metodo para encontrar livros por autor
    List<Livro> findByAuthor(String autor);

    // metodo para buscar livros por titulo (caso o titulo contenha a string fornecida)
    List<Livro> findByTituloContaining(String titulo);

    // metodo para buscar livros por isbn
    Livro findByIsBn(String isbn);
}
