package com.biblioteca.pessoal.dto;

import com.biblioteca.pessoal.domain.Genero;
import com.biblioteca.pessoal.domain.StatusLeitura;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LivroRequest {
    @NotBlank(message = "O título é obrigatório")
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres")
    private String titulo;

    @NotBlank(message = "O autor é obrigatório")
    @Size(max = 120, message = "O autor deve ter no máximo 120 caracteres")
    private String autor;

    @NotNull(message = "O gênero é obrigatório")
    private Genero genero;

    @NotNull(message = "O ano de publicação é obrigatório")
    @Min(value = 1, message = "O ano de publicação deve ser maior que zero")
    @Max(value = 2100, message = "O ano de publicação não pode ser maior que 2100")
    private Integer anoPublicacao;

    @NotNull(message = "O status de leitura é obrigatório")
    private StatusLeitura statusLeitura;

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
