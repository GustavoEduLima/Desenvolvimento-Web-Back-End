package com.example.projetofilmes.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetofilmes.Models.Filmes;

public interface FilmeRepository extends JpaRepository<Filmes, Long>{

    // duração maior que
    List<Filmes> findByDuracaoGreaterThan(Integer duracao);

    // duração menor ou igual
    List<Filmes> findByDuracaoLessThanEqual(Integer duracao);

    // título começando com
    List<Filmes> findByTituloStartingWith(String titulo);
}
