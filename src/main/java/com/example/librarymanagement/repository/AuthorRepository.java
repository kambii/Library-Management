package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("SELECT s FROM Author s WHERE s.authorName = ?1")
    Optional<Author> findAuthorByName(String authorName);
}
