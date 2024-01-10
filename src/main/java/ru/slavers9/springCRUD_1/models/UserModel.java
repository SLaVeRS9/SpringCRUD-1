package ru.slavers9.springCRUD_1.models;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserModel {
    private Long id;

    @NotEmpty(message = "Name must be not empty")
    @Size(min=3, max=20, message = "Name must be between 3 and 20 characters")
    private String name;

    @Min(value = 1, message = "Age must be between 1 and 150")
    @Max(value = 150, message = "Age must be between 1 and 150")
    private Integer age;

    @NotEmpty(message = "Email must be not empty")
    @Email(message = "Invalid email")
    private String email;
}
