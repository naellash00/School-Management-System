package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;

    @NotEmpty(message = "Area cannot be empty")
    @Size(min = 5, max = 15, message = "area must be between 5-15 letters")
    @Column(columnDefinition = "varchar(15) not null")
    private String area;

    @NotEmpty(message = "street cannot be empty")
    @Size(min=5, max = 15, message = "street must be between 5-15 letters")
    @Column(columnDefinition = "varchar(15) not null")
    private String street;

    @Positive(message = "building number cannot be negative")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
