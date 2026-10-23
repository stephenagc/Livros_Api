package com.biblioteca.pessoal.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 120)
    private String autor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Genero genero;

    @Column(nullable = false)
    private Integer anoPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusLeitura statusLeitura;

    public Livro() {}

    public Livro(String titulo, String autor, Genero genero, Integer anoPublicacao, StatusLeitura statusLeitura) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.statusLeitura = statusLeitura;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public StatusLeitura getStatusLeitura() { return statusLeitura; }
    public void setStatusLeitura(StatusLeitura statusLeitura) { this.statusLeitura = statusLeitura; }
}
