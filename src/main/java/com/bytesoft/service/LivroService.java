package com.bytesoft.service;

import com.bytesoft.model.Livro;
import com.bytesoft.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // metodo para salvar ou atualizar um livro
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    // metodo para buscar todos os livros.
    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    // metodo para buscar livros por id
    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    // metodo para buscar livros por autor
    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAuthor(autor);
    }

    // metodo para buscar livros por título
    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    // metodo para buscar livros por isbn
    public Livro buscarPorIsbn(String isbn) {
        return livroRepository.findByIsBn(isbn);
    }

    // metodo para excluir um livro por id
    public void excluir(long id) {
        livroRepository.deleteById(id);
    }
}
