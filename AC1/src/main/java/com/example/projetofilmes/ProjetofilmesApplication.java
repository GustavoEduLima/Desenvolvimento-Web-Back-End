package com.example.projetofilmes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetofilmes.Models.Diretor;
import com.example.projetofilmes.Models.Filmes;
import com.example.projetofilmes.Repositories.DiretorRepository;
import com.example.projetofilmes.Repositories.FilmeRepository;

@SpringBootApplication
public class ProjetofilmesApplication {

		@Bean
    public CommandLineRunner init(
            @Autowired FilmeRepository filmeRepository,
            @Autowired DiretorRepository diretorRepository
    ) {

        return args -> {

            System.out.println("*** INSERINDO DIRETORES ***");

            Diretor d1 = new Diretor(null, "Ryan Coogler", null);
            d1 = diretorRepository.save(d1);

            Diretor d2 = new Diretor(null, "Peter Ramsey", null);
            d2 = diretorRepository.save(d2);


            System.out.println("*** INSERINDO FILMES ***");

            Filmes f1 = new Filmes(null, "Pantera Negra", 148, d1);
            f1 = filmeRepository.save(f1);

            Filmes f2 = new Filmes(null, "Pecadores", 106, d1);
            f2 = filmeRepository.save(f2);

            Filmes f3 = new Filmes(null, "Homem aranha: Atraves do aranhaverso", 154, d2);
            f3 = filmeRepository.save(f3);


            System.out.println("\n*** TESTES FILME ***");

            List<Filmes> maiores = filmeRepository.findByDuracaoGreaterThan(120);
            System.out.println("Duração > 120:");
            maiores.stream().map(Filmes::getTitulo).forEach(System.out::println);

            List<Filmes> menores = filmeRepository.findByDuracaoLessThanEqual(120);
            System.out.println("\nDuração <= 120:");
            menores.stream().map(Filmes::getTitulo).forEach(System.out::println);

            List<Filmes> titulos = filmeRepository.findByTituloStartingWith("P");
            System.out.println("\nTítulo começando com 'P':");
            titulos.stream().map(Filmes::getTitulo).forEach(System.out::println);


            System.out.println("\n*** TESTES DIRETOR ***");

            List<Diretor> diretores = diretorRepository.findByNomeStartingWith("Ryan");
            System.out.println("Diretores com nome começando com 'Ryan':");
            diretores.stream().map(Diretor::getNome).forEach(System.out::println);


            System.out.println("\nBuscar diretor com filmes:");
            diretorRepository.buscarDiretorComFilmes(d1.getId())
                    .ifPresent(d -> {
                        System.out.println("Diretor: " + d.getNome());
                        d.getFilmes().forEach(f ->
                                System.out.println("Filmes: " + f.getTitulo()));
                    });

        };
    }

	public static void main(String[] args) {
		SpringApplication.run(ProjetofilmesApplication.class, args);
	}

}
