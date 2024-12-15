package com.example.schoolmanagementsoftware.Repository;

import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
    Course findCourseById(Integer id);

    //@Query("select c from Course c where c.")
    //Student getCourseStudent(Integer course_id);
}
