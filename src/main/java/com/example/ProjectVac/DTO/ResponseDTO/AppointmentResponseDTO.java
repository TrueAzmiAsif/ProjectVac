package com.example.ProjectVac.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDTO {
    String UserName;
    int phone;
    String gender;
    String centerName;
    String location;
    String docName;
    String vaccineName;
    String doseNumber;
    Date appDate;
    Date bookDate;
}
