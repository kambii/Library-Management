package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Category;
import com.example.librarymanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping
    public void registerNewCategory(@RequestBody Category category){
        categoryService.addNewCategory(category);
    }

    @DeleteMapping("{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping(path = "{categoryId}")
    public void updateGuest(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(required = false) String categoryName){
        categoryService.updateCategory(categoryId, categoryName);
    }
}
