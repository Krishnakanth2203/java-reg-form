package com.example.RegForm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank(message = "email or number is required!")
    private String emailOrNumber;
    @NotBlank(message = "password is required!")
    private String password;
}