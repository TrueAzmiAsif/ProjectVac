package com.example.ProjectVac.Service;

import com.example.ProjectVac.DTO.RequestDTO.UserRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.UserResponseDTO;
//import org.springframework.stereotype.Service;


public interface UserService {
    public UserResponseDTO add(UserRequestDTO userDTO);
}
