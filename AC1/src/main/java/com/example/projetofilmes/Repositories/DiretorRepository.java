package com.example.projetofilmes.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projetofilmes.Models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    // nome começando com
    List<Diretor> findByNomeStartingWith(String nome);

    // buscar com filmes (JOIN FETCH)
    @Query("SELECT d FROM Diretor d LEFT JOIN FETCH d.filmes WHERE d.id = :id")
    Optional<Diretor> buscarDiretorComFilmes(@Param("id") Long id);
}
