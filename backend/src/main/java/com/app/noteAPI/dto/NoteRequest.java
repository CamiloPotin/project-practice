package com.app.noteAPI.dto;

import com.app.noteAPI.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequest {

    private String title;
    private String note;

    private Set<Category> categories;
}
