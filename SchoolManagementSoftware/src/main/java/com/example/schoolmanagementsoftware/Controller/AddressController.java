package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddresses(){
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added successfully"));
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added successfully"));
    }


}
