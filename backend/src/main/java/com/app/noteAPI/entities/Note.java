package com.app.noteAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;



@Entity  // Se usa para definir que la clase es una entidad y debe guardarse en base de datos
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {

    @Id     // Se usa para seleccionar la clave primaria de la clase
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Indica que se genere automaticamente el valor de id
    private Long id;

    private String title;

    private String note;

    private boolean archived;

    @ManyToMany
    @JoinTable(
            name = "nota_categoria",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

}
