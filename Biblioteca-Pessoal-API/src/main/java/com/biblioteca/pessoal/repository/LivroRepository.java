package com.biblioteca.pessoal.repository;
import com.biblioteca.pessoal.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LivroRepository extends JpaRepository<Livro, Long> {}
