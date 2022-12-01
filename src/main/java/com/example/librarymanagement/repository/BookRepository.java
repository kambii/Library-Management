package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT s FROM Book s WHERE s.bookName = ?1")
    Optional<Book> findBookByName(String bookName);
    @Query("SELECT s FROM Book s WHERE s.isbn = ?1")
    Optional<Book> findBookByIsbn(String isbn);
    @Query("SELECT s FROM Book s WHERE s.serialName = ?1")
    Optional<Book> findBookBySerialName(String serialName);
    @Query("SELECT s FROM Book s WHERE s.description = ?1")
    Optional<Book> findBookByDescription(String description);
}
