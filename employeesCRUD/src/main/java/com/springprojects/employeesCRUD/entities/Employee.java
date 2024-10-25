package com.springprojects.employeesCRUD.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message = "No debe estar vacio")
    @Size(
            min = 6, max = 20,
            message = "El nombre debe contener entre 6 y 20 caracteres")
    private String name;

    @NotBlank (message = "No debe estar vacio")
    @Size(
            max = 20,
            message = "No debe tener mas de 20 caracteres")

    private String occupation;

    public Employee() {

    }

    public Employee(Long id, String name, String occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String ocupation) {
        this.occupation = ocupation;
    }
}
