package com.example.schoolmanagementsoftware.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "name cannot be null")
    private String name;

    @NotNull(message = "age cannot be empty")
    private Integer age;

    @NotEmpty(message = "major cannot be empty")
    private String major;

    private List<CourseDTO> courseDTOS;
}
