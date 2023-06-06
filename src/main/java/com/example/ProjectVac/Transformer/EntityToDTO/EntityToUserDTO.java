package com.example.ProjectVac.Transformer.EntityToDTO;

import com.example.ProjectVac.DTO.ResponseDTO.UserResponseDTO;
import com.example.ProjectVac.Model.User;

public class EntityToUserDTO {
    public static UserResponseDTO userToDTO(User user,String message){
        return UserResponseDTO.builder()
                .name(user.getName())
                .message(message)
                .build();
    }
}
