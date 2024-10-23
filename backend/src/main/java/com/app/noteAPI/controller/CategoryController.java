package com.app.noteAPI.controller;

import com.app.noteAPI.entities.Category;
import com.app.noteAPI.entities.Note;
import com.app.noteAPI.repository.CategoryRepository;
import com.app.noteAPI.repository.NoteRepository;
import com.app.noteAPI.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CategoryController {



    private final CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository, NoteRepository noteRepository, CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping("api/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }



    @DeleteMapping("api/category/{categoryId}")
    public ResponseEntity<Category> deleteCategory(@PathVariable long categoryId) {
        try {
            return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
