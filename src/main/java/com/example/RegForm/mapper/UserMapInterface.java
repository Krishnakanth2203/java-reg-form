package com.example.RegForm.mapper;

import com.example.RegForm.dto.UserDto;
import com.example.RegForm.entity.UserEntity;
import com.example.RegForm.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapInterface {

    UserModel dtoToModel(UserDto dto);

    UserEntity modelToEntity (UserModel model);

    UserModel entityToModel (UserEntity entity);
}