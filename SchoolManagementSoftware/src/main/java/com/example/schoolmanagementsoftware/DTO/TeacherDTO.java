package com.example.schoolmanagementsoftware.DTO;

import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class TeacherDTO {

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3, max = 10, message = "name must be between 3-10 letters")
    private String name;

    @Min(value = 20, message = "age cannot be less than 20")
    private Integer age;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "enter a valid email")
    private String email;

    @Positive(message = "salary must be positive")
    private Integer salary;

//    private AddressDTO addressDTO;
//
//    private List<CourseDTO> courseDTOS;
}
