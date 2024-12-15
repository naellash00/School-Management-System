package com.example.schoolmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be null")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;

    @NotNull(message = "age cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "major cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
