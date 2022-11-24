package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Category;
import com.example.librarymanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(category.getCategoryName());
        if (categoryOptional.isPresent()){
            throw new IllegalStateException("categoryName taken");
        }
        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        boolean exists = categoryRepository.existsById(categoryId);
        if (!exists){
            throw new IllegalStateException("category with id" + categoryId + "does not exists");
        }
        categoryRepository.deleteById(categoryId);
    }

    @Transactional
    public void updateCategory(Long categoryId, String categoryName) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException(
                        "category with id" + categoryId + "does not exist"));

        if (categoryName != null && categoryName.length() > 0 &&
                !Objects.equals(category.getCategoryName(), categoryName)){
            category.setCategoryName(categoryName);
        }
    }
}
