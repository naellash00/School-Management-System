package com.example.schoolmanagementsoftware.DTO;

import com.example.schoolmanagementsoftware.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseDTO {

    @NotEmpty(message = "name cannot be empty")
    private String name;

   //private TeacherDTO teacherDTO;
}
