package com.biblioteca.pessoal.config;

import com.biblioteca.pessoal.domain.Genero;
import com.biblioteca.pessoal.domain.Livro;
import com.biblioteca.pessoal.domain.StatusLeitura;
import com.biblioteca.pessoal.repository.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DadosIniciais implements CommandLineRunner {
    private final LivroRepository livroRepository;
    public DadosIniciais(LivroRepository livroRepository) { this.livroRepository = livroRepository; }

    @Override
    public void run(String... args) {
        if (livroRepository.count() > 0) return;
        livroRepository.save(new Livro("O Hobbit", "J. R. R. Tolkien", Genero.FANTASIA, 1937, StatusLeitura.LIDO));
        livroRepository.save(new Livro("Dom Casmurro", "Machado de Assis", Genero.ROMANCE, 1899, StatusLeitura.NAO_LIDO));
    }
}
