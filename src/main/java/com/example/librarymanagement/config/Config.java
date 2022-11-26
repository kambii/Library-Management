package com.example.librarymanagement.config;

import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.Category;
import com.example.librarymanagement.entity.Publisher;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.CategoryRepository;
import com.example.librarymanagement.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository){
        return args -> {
            Author authorName = new Author(
                    "kambal",
                    "Application_Development"
            );
            authorRepository.saveAll(
                    List.of(authorName)
            );
        };
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
      return args -> {
          Book bookName = new Book(

                  "isbn",
                  "spring_boot",
                  "",
                  "Application_Development"
          );
          bookRepository.saveAll(
            List.of(bookName)
          );
      };
    };

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository){
        return args -> {
            Category categoryName = new Category(

                    "programming"
            );
            categoryRepository.saveAll(
                    List.of(categoryName)
            );
        };
    }

    @Bean
    CommandLineRunner commandLineRunner(PublisherRepository publisherRepository){
        return args -> {
            Publisher publisherName = new Publisher(
                    "johan"
            );
            publisherRepository.saveAll(
                    List.of(publisherName)
            );
        };
    }
}
