package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.DTO.CourseDTO;
import com.example.schoolmanagementsoftware.DTO.StudentDTO;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s : students) {
            List<CourseDTO> courseDTOS = new ArrayList<>();
            for(Course c : s.getCourses()){
                CourseDTO courseDTO = new CourseDTO(c.getName());
                courseDTOS.add(courseDTO);
            }
            StudentDTO studentDTO = new StudentDTO(s.getName(), s.getAge(), s.getMajor(), courseDTOS);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student oldStudent = studentRepository.findStudentById(id);
        if(oldStudent == null){
            throw new ApiException("student not found");
        }
        oldStudent.setName(student.getName());
        student.setAge(student.getAge());
        student.setMajor(student.getMajor());
        studentRepository.save(student);
    }
    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student == null){
            throw new ApiException("student not found");
        }
        studentRepository.delete(student);
    }

    public void enrollInCourse(Integer student_id, Integer course_id){
        // check student and copurse id
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if(student == null || course == null){
            throw new ApiException("cannot enroll");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        courseRepository.save(course);
        studentRepository.save(student);
    }

    public void changeStudentMajor(Integer id, String major){
        // check student id
        Student student = studentRepository.findStudentById(id);
        if(student == null){
            throw new ApiException("student not found");
        }
        for(Course course : student.getCourses()){
            course.getStudents().remove(student);
        }
        student.setMajor(major);
        student.getCourses().clear();
        //student.setCourses(null);
        studentRepository.save(student);
    }
}
