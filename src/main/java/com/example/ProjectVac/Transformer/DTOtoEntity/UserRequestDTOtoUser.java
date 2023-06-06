package com.example.ProjectVac.Transformer.DTOtoEntity;

import com.example.ProjectVac.DTO.RequestDTO.UserRequestDTO;
import com.example.ProjectVac.Model.User;

public class UserRequestDTOtoUser {
    public static User userRequestDTOtoUser(UserRequestDTO userDTO){
        User newUser=User.builder()
                .name(userDTO.getName())
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .build();
        return newUser;
    }
}
