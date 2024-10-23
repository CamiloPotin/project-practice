package com.app.noteAPI.service;


import com.app.noteAPI.entities.Category;
import com.app.noteAPI.entities.Note;
import com.app.noteAPI.repository.CategoryRepository;
import com.app.noteAPI.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final NoteRepository noteRepository;

    public CategoryService(CategoryRepository categoryRepository, NoteRepository noteRepository) {
        this.categoryRepository = categoryRepository;
        this.noteRepository = noteRepository;

    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category deleteCategory(Long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            List<Note> notes = noteRepository.findByCategories_Name(category.get().getName());
            Category categoryToDelete = category.get();
            for(Note note : notes) {
                Set<Category> categories = note.getCategories();
                categories.remove(categoryToDelete);
                note.setCategories(categories);
                noteRepository.save(note);
            }
            categoryRepository.delete(categoryToDelete);
            return categoryToDelete;
        } else{
            throw new EntityNotFoundException("Category not found");
        }

    }
}
