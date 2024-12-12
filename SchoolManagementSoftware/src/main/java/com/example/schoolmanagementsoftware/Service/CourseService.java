package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }
    //assign teacher to course

    public void assignTeacherToCourse(Integer teacher_id, Integer course_id) {
        // check if teacher and course IDs exist
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if (teacher == null || course == null) {
            throw new ApiException("cant assign");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if(course == null){
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }
}
