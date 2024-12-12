package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course Added Successfully"));
    }

    @PutMapping("assign/teacher/to-course/{teacher_id}/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
        courseService.assignTeacherToCourse(teacher_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("course assigned successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted successfully"));
    }
}
