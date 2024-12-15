package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.DTO.CourseDTO;
import com.example.schoolmanagementsoftware.DTO.StudentDTO;
import com.example.schoolmanagementsoftware.DTO.TeacherDTO;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final AddressService addressService;

//    public List<Course> getAllCourses() {
//        return courseRepository.findAll();
//    }

    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        //List<TeacherDTO> teacherDTOS = new ArrayList<>();
        for (Course c : courses) {
          //  TeacherDTO teacherDTO = new TeacherDTO(c.getTeacher().getName(), c.getTeacher().getAge(), c.getTeacher().getEmail(), c.getTeacher().getSalary(), );
            CourseDTO courseDTO = new CourseDTO(c.getName());
            courseDTOS.add(courseDTO);
        }
        return courseDTOS;
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
        if (course == null) {
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }

    public String getTeacherNameByCourse(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {
            throw new ApiException("Course Not Found");
        }

        return course.getTeacher().getName();
        //getTeacherDTO
        //   return new CourseDTO(course.getTeacher().getName());
        // return new CourseDTO(course.getName(), new TeacherDTO(course.getName())).getTeacherDTO().
    }

    public List<StudentDTO> getStudentsInCourse(Integer course_id){
        // check course exist
        Course course = courseRepository.findCourseById(course_id);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        if(course == null){
            throw new ApiException("course not found");
        }
        Set<Student> students = course.getStudents();
        for(Student s : students){
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
}
