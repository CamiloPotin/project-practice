package com.app.noteAPI.repository;

import com.app.noteAPI.entities.Category;
import com.app.noteAPI.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
