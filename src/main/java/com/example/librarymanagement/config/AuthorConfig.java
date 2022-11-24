package com.example.librarymanagement.config;

import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AuthorConfig {

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository){
        return args -> {
            Author kambal = new Author(
                    "kambal",
                    "Application Development"
            );
            authorRepository.saveAll(
                    List.of(kambal)
            );
        };
    }
}
