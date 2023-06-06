package com.example.ProjectVac.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDTO {
    String name;
    String centerID;
    String centerName;
    String location;
    String message;
}
