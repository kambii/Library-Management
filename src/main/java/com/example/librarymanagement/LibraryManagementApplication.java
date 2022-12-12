package com.example.librarymanagement;


import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.Category;
import com.example.librarymanagement.entity.Publisher;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.CategoryRepository;
import com.example.librarymanagement.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository repository, BookRepository bookRepository, CategoryRepository categoryRepository, PublisherRepository publisherRepository){
        return args -> {
            Author authorName1 = new Author(
                    "john",
                    "i have worked as an author for 10 years"
            );
            Author authorName2 = new Author(
                    "louis",
                    " i like righting books i love my job as an author"
            );
            repository.saveAll(
                    List.of(authorName1, authorName2)
            );
            Book bookName1 = new Book(
                    "isbn",
                    "springBoot",
                    "spring",
                    "application development"
            );
            Book bookName2 = new Book(
                    "isbn",
                    "springBoot2",
                    "spring2",
                    "application development"
            );
            bookRepository.saveAll(
                    List.of(bookName1, bookName2)
            );
            Category categoryName1 = new Category(
                    "programming"
            );
            Category categoryName2 = new Category(
                    "software developer"
            );
            categoryRepository.saveAll(
                    List.of(categoryName1, categoryName2)
            );
            Publisher publisherName1 = new Publisher(
                    "kambii"
            );
            Publisher publisherName2 = new Publisher(
                    "tindra"
            );
            publisherRepository.saveAll(
                    List.of(publisherName1, publisherName2)
            );
        };
    }



}
