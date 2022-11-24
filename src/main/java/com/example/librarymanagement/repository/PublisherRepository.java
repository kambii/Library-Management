package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {

    @Query("SELECT s FROM Publisher s WHERE s.publisherName = ?1")
    Optional<Publisher> findPublisherByName(String publisherName);
}
