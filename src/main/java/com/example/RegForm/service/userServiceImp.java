package com.example.RegForm.service;

import com.example.RegForm.dto.UserDto;
import com.example.RegForm.entity.UserEntity;
import com.example.RegForm.mapper.UserMapInterface;
import com.example.RegForm.model.UserModel;
import com.example.RegForm.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class userServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapInterface usermapInterface;

    @Override
    public UserModel getUserById(Long id) {
        return userRepo.findById(id)
                .map(usermapInterface::entityToModel)
                .orElse(null);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserEntity> entities = userRepo.findAll();
        List<UserModel> models = new ArrayList<>();
        for (UserEntity entity : entities) {
            models.add(usermapInterface.entityToModel(entity));
        }
        return models;
    }

    @Override
    public UserModel loginUser(String emailOrNumber, String password) {
        Optional<UserEntity> optionalUser;

        // Trim input to avoid extra spaces
        emailOrNumber = emailOrNumber.trim();
        password = password.trim();

        // Check if input is a number (digits only)
        if (emailOrNumber.matches("\\d+")) {
            // Input is a number
            optionalUser = userRepo.findByNumberAndPassword(emailOrNumber, password);
        } else {
            // Input is an email
            optionalUser = userRepo.findByEmailAndPassword(emailOrNumber.toLowerCase(), password);
        }

        return optionalUser.map(usermapInterface::entityToModel).orElse(null);
    }

    @Override
    public String RegUser(UserDto userDTO){
        if(userRepo.existsByEmail(userDTO.getEmail())){
            return "Email already exists";
        }
        if (userRepo.existsByNumber(userDTO.getNumber())){
            return "Number already exists";
        }

        UserModel model = usermapInterface.dtoToModel(userDTO);
        UserEntity entity = usermapInterface.modelToEntity(model);
        userRepo.save(entity);

        return "User registered successfully";
    }
}