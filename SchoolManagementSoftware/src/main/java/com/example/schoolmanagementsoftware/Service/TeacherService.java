package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.AddressRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if(oldTeacher == null){
            throw new ApiException("Teacher Not Found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher ID Not Found");
        }
        Address address = addressRepository.findAddressById(id);
        teacher.setAddress(null);
        addressRepository.delete(address);
        teacherRepository.delete(teacher);
    }

}
