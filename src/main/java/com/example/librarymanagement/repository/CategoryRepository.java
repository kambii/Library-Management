package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT s FROM Category s WHERE s.categoryName = ?1")
    Optional<Category> findCategoryByName(String categoryName);
}
