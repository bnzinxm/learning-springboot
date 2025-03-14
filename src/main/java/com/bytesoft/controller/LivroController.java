package com.bytesoft.controller;

import com.bytesoft.model.Livro;
import com.bytesoft.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class LivroController {
    
    @Autowired
    private LivroService livroService;

    // endpoint para listar todos os livros.

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.buscarTodos();
    }

    // endpoint para buscar um livro por id
    @GetMapping("/{id}")

    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroService.buscarPorId(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // endpoint para buscar livros por autor
    @GetMapping("/autor/{autor}")

    public List<Livro> buscarPorAutor(@PathVariable String autor) {
        return livroService.buscarPorAutor(autor);
    }

    // endpoint para buscar livros por isbn
    @GetMapping("/isbn/{isbn}")

    public ResponseEntity<Livro> buscarPorIsbn(@PathVariable String isbn) {
        Livro livro = livroService.buscarPorIsbn(isbn);
        return livro != null ? ResponseEntity.ok(livro) : ResponseEntity.notFound().build();
    }

    // endpoint para salvar um novo livro
    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    // endpoint para editar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable long id, @RequestBody Livro livro) {
        if (livroService.buscarPorId(id).isPresent()) {
            livro.setId(id);
            return ResponseEntity.ok(livroService.salvar(livro));
        }
        return ResponseEntity.notFound().build();
    }

    // endpoint para deletar um livro por id
    @DeleteMapping("/{id}")
    
    public ResponseEntity<Void> excluirLivro(@PathVariable long id) {
        if (livroService.buscarPorId(id).isPresent()) {
            livroService.excluir(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
