package com.app.noteAPI.controller;

import com.app.noteAPI.entities.Category;
import com.app.noteAPI.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("api/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
