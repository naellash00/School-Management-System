package com.example.schoolmanagementsoftware.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotEmpty(message = "Area cannot be empty")
    @Size(min = 5, max = 15, message = "area must be between 5-15 letters")
    private String area;

    @NotEmpty(message = "street cannot be empty")
    @Size(min = 5, max = 15, message = "street must be between 5-15 letters")
    private String street;

    @Positive(message = "building number cannot be negative")
    private Integer buildingNumber;
}
