package com.example.schoolmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Check;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "(age >= 20) and (salary > 0)")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3, max = 10, message = "name must be between 3-10 letters")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @Min(value = 20, message = "age cannot be less than 20")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "enter a valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @Positive(message = "salary must be positive")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;

}
