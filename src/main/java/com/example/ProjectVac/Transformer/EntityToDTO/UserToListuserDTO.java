package com.example.ProjectVac.Transformer.EntityToDTO;

import com.example.ProjectVac.DTO.ResponseDTO.UserListResponseDTO;

import java.util.List;

public class UserToListuserDTO {
    public static UserListResponseDTO userToListuserDTO(List<String> names, String message){
        return UserListResponseDTO.builder()
                .names(names)
                .message(message)
                .build();
    }
}
