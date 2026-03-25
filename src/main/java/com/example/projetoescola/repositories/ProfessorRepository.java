package com.example.projetoescola.repositories;

import com.example.projetoescola.models.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

public class ProfessorRepository extends JpaRepository<Professor, Long> {
        // salário maior que
    List<Professor> findBySalarioGreaterThan(Double salario);

    // salário menor ou igual
    List<Professor> findBySalarioLessThanEqual(Double salario);

    // nome começando com
    List<Professor> findByNomeStartingWith(String nome);
    
}
