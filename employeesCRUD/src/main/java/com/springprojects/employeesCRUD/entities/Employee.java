package com.springprojects.employeesCRUD.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 10)
    private String phone;

    @NotBlank
    @Min(18)
    @Max(60)
    private String age;

}
