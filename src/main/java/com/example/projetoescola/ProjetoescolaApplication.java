package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Professor;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init( @Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaCursoRepository ) {
			return args ->{
				System.out.println("*** INSERINDO CATEGORIA ***");
				CategoriaCurso cc1 = new CategoriaCurso(null, "Tecnologia", null);
				cc1 = categoriaCursoRepository.save(cc1);

				System.out.println("*** INSERINDO CURSO ***");
					Curso c1 = new Curso( null, "ADS", 2000, cc1);
					Curso c2 = new Curso( null, "JD", 2100, null);
					c1 = cursoRepository.save(c1);
					c2 = cursoRepository.save(c2);

					List<Curso> cursos = cursoRepository.findByNomeLike("A%");
					System.out.println("*** CURSOS ENCONTRADOS ***");
					cursos.stream().map(Curso:: getNome).forEach(System.out::println);

					            // Criando 6 professores
            repo.save(new Professor("Ana", 3000.0));
            repo.save(new Professor("Bruno", 4500.0));
            repo.save(new Professor("Carlos", 2000.0));
            repo.save(new Professor("Amanda", 5000.0));
            repo.save(new Professor("Beatriz", 1500.0));
            repo.save(new Professor("André", 3500.0));

            System.out.println("=== Salário > 3000 ===");
            repo.findBySalarioGreaterThan(3000.0)
                .forEach(p -> System.out.println(p.getNome()));

            System.out.println("=== Salário <= 3000 ===");
            repo.findBySalarioLessThanEqual(3000.0)
                .forEach(p -> System.out.println(p.getNome()));

            System.out.println("=== Nome começando com 'A' ===");
            repo.findByNomeStartingWith("A")
                .forEach(p -> System.out.println(p.getNome()));
			};

		}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}


}