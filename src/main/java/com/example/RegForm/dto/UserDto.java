package com.example.RegForm.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Data
public class UserDto {

    @NotBlank(message = "Name is required!")
    private String name;
    @NotBlank(message = "Address is required!")
    private String address;
    @NotBlank(message = "Email is required!")
    @Email(message = "Email format is invalid!")
    private String email;
    @NotBlank(message = "Mobile number is required!")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
    private String number;
    @NotBlank(message = "Password is required!")
    private String password;
}