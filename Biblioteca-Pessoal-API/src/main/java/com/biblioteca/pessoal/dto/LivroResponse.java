package com.biblioteca.pessoal.dto;
import com.biblioteca.pessoal.domain.Genero;
import com.biblioteca.pessoal.domain.Livro;
import com.biblioteca.pessoal.domain.StatusLeitura;

public class LivroResponse {
    private Long id;
    private String titulo;
    private String autor;
    private Genero genero;
    private Integer anoPublicacao;
    private StatusLeitura statusLeitura;
    public LivroResponse() {}
    public static LivroResponse from(Livro livro) {
        LivroResponse response = new LivroResponse();
        response.id = livro.getId();
        response.titulo = livro.getTitulo();
        response.autor = livro.getAutor();
        response.genero = livro.getGenero();
        response.anoPublicacao = livro.getAnoPublicacao();
        response.statusLeitura = livro.getStatusLeitura();
        return response;
    }
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public Genero getGenero() { return genero; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public StatusLeitura getStatusLeitura() { return statusLeitura; }
}
