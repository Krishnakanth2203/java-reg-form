package com.example.RegForm.service;

import com.example.RegForm.dto.UserDto;
import com.example.RegForm.model.UserModel;

import java.util.List;

public interface UserService {
    String RegUser(UserDto userDTO);

    UserModel getUserById(Long id);

    List<UserModel> getAllUsers();

    UserModel loginUser(String emailOrNumber, String password);
}