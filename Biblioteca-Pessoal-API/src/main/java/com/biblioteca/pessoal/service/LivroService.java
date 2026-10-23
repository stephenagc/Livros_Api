package com.biblioteca.pessoal.service;

import com.biblioteca.pessoal.domain.Livro;
import com.biblioteca.pessoal.dto.LivroRequest;
import com.biblioteca.pessoal.dto.LivroResponse;
import com.biblioteca.pessoal.exception.RecursoNaoEncontradoException;
import com.biblioteca.pessoal.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    public LivroService(LivroRepository livroRepository) { this.livroRepository = livroRepository; }

    @Transactional
    public LivroResponse cadastrar(LivroRequest request) {
        Livro livro = new Livro(request.getTitulo().trim(), request.getAutor().trim(),
                request.getGenero(), request.getAnoPublicacao(), request.getStatusLeitura());
        return LivroResponse.from(livroRepository.save(livro));
    }

    @Transactional(readOnly = true)
    public List<LivroResponse> listarTodos() {
        return livroRepository.findAll().stream().map(LivroResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public LivroResponse buscarPorId(Long id) { return LivroResponse.from(buscarEntidade(id)); }

    @Transactional
    public LivroResponse atualizar(Long id, LivroRequest request) {
        Livro livro = buscarEntidade(id);
        livro.setTitulo(request.getTitulo().trim());
        livro.setAutor(request.getAutor().trim());
        livro.setGenero(request.getGenero());
        livro.setAnoPublicacao(request.getAnoPublicacao());
        livro.setStatusLeitura(request.getStatusLeitura());
        return LivroResponse.from(livroRepository.save(livro));
    }

    @Transactional
    public void excluir(Long id) { livroRepository.delete(buscarEntidade(id)); }

    private Livro buscarEntidade(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado com o ID " + id));
    }
}
