package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("deleted successfully");
    }

    @PutMapping("/enroll/{student_id}/{course_id}")
    public ResponseEntity enrollInCourse(@PathVariable Integer student_id, @PathVariable Integer course_id){
        studentService.enrollInCourse(student_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("you enrolled successfully"));
    }

    @PutMapping("/change/major/{student_id}/{major}")
    public ResponseEntity changeStudentMajor(@PathVariable Integer student_id, @PathVariable String major){
        studentService.changeStudentMajor(student_id, major);
        return ResponseEntity.status(200).body(new ApiResponse("major changed successfully"));
    }
}
