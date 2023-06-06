package com.example.ProjectVac.DTO.RequestDTO;

import com.example.ProjectVac.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserRequestDTO {
    String name;
    int phone;
    String email;
    int age;
    Gender gender;
}
