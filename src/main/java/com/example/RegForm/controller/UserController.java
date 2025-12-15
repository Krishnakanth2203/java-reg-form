package com.example.RegForm.controller;

import com.example.RegForm.dto.LoginDto;
import com.example.RegForm.dto.UserDto;
import com.example.RegForm.model.UserModel;
import com.example.RegForm.service.userServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private userServiceImp userServiceImp;

    @PostMapping("/register")
    public String register(@Valid @RequestBody UserDto userDTO){
        return userServiceImp.RegUser(userDTO);
    }

    @GetMapping("/id/{id}")
    public UserModel getUserById(@PathVariable Long id){
        return userServiceImp.getUserById(id);
    }

    @GetMapping
    public List<UserModel> getAllUsers(){
        return userServiceImp.getAllUsers();
    }

    @GetMapping(value = "/login", produces = "application/json")
    public ResponseEntity<?> loginUser (@RequestBody LoginDto loginDTO) {
        UserModel user = userServiceImp.loginUser(loginDTO.getEmailOrNumber(), loginDTO.getPassword());

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid email/number or password"));
        }
    }



}