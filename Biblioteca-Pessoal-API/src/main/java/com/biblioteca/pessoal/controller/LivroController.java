package com.biblioteca.pessoal.controller;

import com.biblioteca.pessoal.dto.LivroRequest;
import com.biblioteca.pessoal.dto.LivroResponse;
import com.biblioteca.pessoal.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;
    public LivroController(LivroService livroService) { this.livroService = livroService; }

    @PostMapping
    public ResponseEntity<LivroResponse> cadastrar(@Valid @RequestBody LivroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.cadastrar(request));
    }
    @GetMapping
    public ResponseEntity<List<LivroResponse>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> atualizar(@PathVariable Long id, @Valid @RequestBody LivroRequest request) {
        return ResponseEntity.ok(livroService.atualizar(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        livroService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
