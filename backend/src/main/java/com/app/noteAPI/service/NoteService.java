package com.app.noteAPI.service;


import com.app.noteAPI.dto.NoteRequest;
import com.app.noteAPI.entities.Category;
import com.app.noteAPI.entities.Note;
import com.app.noteAPI.repository.CategoryRepository;
import com.app.noteAPI.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final CategoryRepository categoryRepository;

    public Note createNote(NoteRequest noteDto) {


        Note newNote = new Note();
        newNote.setTitle(noteDto.getTitle());
        newNote.setNote(noteDto.getNote());
       // newNote.setCategories(noteDto.getCategories());

        return addCategories(newNote, noteDto.getCategories());
    }


    public Note update(Note note) {
        if (note.getId() == null) {
            throw new IllegalArgumentException("Note ID must not be null");
        }
        if (!noteRepository.existsById(note.getId())) {
            throw new EntityNotFoundException("Note not found");
        }

        // Lista para almacenar categorías existentes o nuevas
        return addCategories(note, note.getCategories());
    }


    public List<Note> getNotesForCategory(String category) {
        return noteRepository.findByCategories_Name(category);

    }


    public Note deleteCategoryFromNote(Long categoryId, Long noteId) throws EntityNotFoundException {
        //todo: Revisar, si existe la categoria se la borra, pero si no tiene ninguna asociada lo hace igual
        Optional<Note> optNote = noteRepository.findById(noteId);
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        //System.out.println(optNote.isPresent()+" "+optionalCategory.isPresent());
        if(optNote.isPresent() && optionalCategory.isPresent()){
            Note note = optNote.get();
            Category category = optionalCategory.get();
            note.getCategories().remove(category);
            category.getNotes().remove(note);
            categoryRepository.save(category);
            noteRepository.save(note);
           // return ResponseEntity.ok(note);
            return note;
        }
        throw new EntityNotFoundException("Category or Note not found");

    }

    public Note deleteNote (Long noteId) throws EntityNotFoundException {
        Optional<Note> optNote = noteRepository.findById(noteId);
        if(optNote.isPresent()){
            Note note = optNote.get();

            for (Category category : note.getCategories()) {
                category.getNotes().remove(note);
                categoryRepository.save(category);
            }
            noteRepository.delete(note);
            return note;
        }
        throw new EntityNotFoundException("Note not found");

    }

    private Note addCategories(Note newNote, Set<Category> categories2) {
        Set<Category> categories = new HashSet<>();
        for (Category category : categories2) {
            Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());
            if (categoryOptional.isPresent()) {
                // Si la categoría ya existe, la añadimos
                categories.add(categoryOptional.get());
            } else {
                // Si no existe, la creamos y la guardamos
                Category newCategory = new Category();
                newCategory.setName(category.getName());
                categories.add(categoryRepository.save(newCategory)); // Guarda y añade la nueva categoría
            }
        }
        newNote.setCategories(categories);
        return noteRepository.save(newNote);
    }

}
