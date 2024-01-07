package ru.slavers9.springCRUD_2.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "Users", schema = "Users")
public class UserModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name must be not empty")
    @Size(min=3, max=20, message = "Name must be between 3 and 20 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 1, message = "Age must be between 1 and 150")
    @Max(value = 150, message = "Age must be between 1 and 150")
    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "Email must be not empty")
    @Email(message = "Invalid email")
    @Column(name = "email")
    private String email;
}
