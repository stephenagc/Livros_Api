package com.biblioteca.pessoal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.biblioteca.pessoal.domain.Genero;
import com.biblioteca.pessoal.domain.StatusLeitura;
import com.biblioteca.pessoal.dto.LivroRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LivroControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    void deveListarLivrosIniciais() throws Exception {
        mockMvc.perform(get("/livros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void deveCadastrarConsultarAtualizarEExcluirLivro() throws Exception {
        LivroRequest cadastro = novoLivro();
        String resposta = mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cadastro)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo", is("A Sociedade do Anel")))
                .andExpect(jsonPath("$.autor", is("J. R. R. Tolkien")))
                .andReturn().getResponse().getContentAsString();

        Long id = objectMapper.readTree(resposta).get("id").asLong();

        mockMvc.perform(get("/livros/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.genero", is("FANTASIA")));

        cadastro.setStatusLeitura(StatusLeitura.LIDO);
        cadastro.setAnoPublicacao(1954);
        mockMvc.perform(put("/livros/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cadastro)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusLeitura", is("LIDO")))
                .andExpect(jsonPath("$.anoPublicacao", is(1954)));

        mockMvc.perform(delete("/livros/" + id)).andExpect(status().isNoContent());
        mockMvc.perform(get("/livros/" + id)).andExpect(status().isNotFound());
    }

    @Test
    void deveRejeitarCadastroSemTitulo() throws Exception {
        LivroRequest cadastro = novoLivro();
        cadastro.setTitulo(" ");
        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cadastro)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.campos.titulo", is("O título é obrigatório")));
    }

    private LivroRequest novoLivro() {
        LivroRequest livro = new LivroRequest();
        livro.setTitulo("A Sociedade do Anel");
        livro.setAutor("J. R. R. Tolkien");
        livro.setGenero(Genero.FANTASIA);
        livro.setAnoPublicacao(1954);
        livro.setStatusLeitura(StatusLeitura.NAO_LIDO);
        return livro;
    }
}
