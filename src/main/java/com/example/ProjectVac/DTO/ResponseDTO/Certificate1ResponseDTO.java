package com.example.ProjectVac.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Certificate1ResponseDTO {
    String name;
    String gender;
    int phone;
    String certificateID;
    String vaccineName;
    String vaccineId;
    String centerName;
    String cenetrId;
}
