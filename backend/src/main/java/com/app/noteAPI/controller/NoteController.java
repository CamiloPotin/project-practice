package com.app.noteAPI.controller;

import com.app.noteAPI.dto.NoteRequest;
import com.app.noteAPI.entities.Note;
import com.app.noteAPI.repository.NoteRepository;
import com.app.noteAPI.service.NoteService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
public class NoteController {


    private final NoteRepository noteRepository;
    private final NoteService noteService;
    private final Logger log = LoggerFactory.getLogger(NoteController.class);

    public NoteController(NoteRepository repository, NoteService noteService) {
        this.noteRepository = repository;
        this.noteService = noteService;
    }

    /**
     * Funcion que retorna todas las notas existentes cuando se llama a la API
     * @return lista de notas
     */
    @GetMapping("/api/notes")
    public List<Note> findAll(){

       return noteRepository.findAll();
    }


    /**
     * Funcion que retorna una lista de notas que contengan la categoria
     * @param category  categoria por la cual se busca las notas
     * @return lista de notas que contienen esa categoria
     */
//    @GetMapping("/api/notes/{category}")
//    public List<Note> findOneByCategory(@PathVariable String category){
//
//        return noteRepository.findByCategoryContaining(category);
//        }

    /**
     * Funcion encargada de crear una nueva nota
     * @param note la nota nueva a ser creada
     * @return una respuesta a la solucitud OK indicando que se creo la nota
     */
    @PostMapping("/api/notes")
    public  ResponseEntity<Note> create(@RequestBody NoteRequest note){


        return ResponseEntity.ok(noteService.createNote(note));

    }

    /**
     * Funcion encargada de actualizar una nota dada
     * @param note la nueva nota para guardar
     * @return devuelve una respuesta Ok si se pudo actualizar, bad reques si no tiene id
     * y notFound si no existe la nota a actualizar
     */
    @PutMapping("/api/notes")
    public  ResponseEntity<Note> update(@RequestBody Note note){

        try {
            Note result = noteService.update(note);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            log.warn("Trying to update a non-existent note", e);
            return ResponseEntity.badRequest().build();
        } catch (EntityNotFoundException e) {
            log.warn("Trying to update a non-existent note", e);
            return ResponseEntity.notFound().build();
        }

    }



    @GetMapping("/api/notes/{category}")
    public  ResponseEntity<List<Note>> getAllForCategory(@PathVariable String category){

        return ResponseEntity.ok(noteService.getNotesForCategory(category));

    }
    /**
     * Funcion encargada de borrar una categoria de la nota mandada por parametro
     * @param noteId es el ID de la nota a la cual se borra la categoria
     * @param categoryId categoriaId a borrar
     * @return retorna OK si se pudo borrar y notFound si no existe la nota
     */
    @DeleteMapping("api/notes/{noteId}/{categoryId}")
    public ResponseEntity<Note> deleteCategoryFromNote(@PathVariable Long noteId,@PathVariable Long categoryId) {
        try {
            Note note = noteService.deleteCategoryFromNote(categoryId,noteId);
            return ResponseEntity.ok(note);
        } catch (EntityNotFoundException e) {
            log.warn("Trying to delete a non-existent note", e);
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Metodo encargado de borrar una nota especificada por parametros
     * @param id el ID de la nota a borrar
     * @return devuelve un notFound si no existe la nota a borrar y un noContent si se pudo borrar
     */
    @DeleteMapping("/api/notes/{id}")
    public  ResponseEntity<Note> delete(@PathVariable Long id){
        try {

            return ResponseEntity.ok(noteService.deleteNote(id));
        }  catch (EntityNotFoundException e) {
            log.warn("Trying to delete a non-existent note", e);
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Metodo encargado de borrar todas las notas
     * @return retorna un noContent
     */
    @DeleteMapping("/api/notes")
    public  ResponseEntity<Note> deleteAll(){
        noteRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
