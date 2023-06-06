package com.example.ProjectVac.DTO.RequestDTO;

import com.example.ProjectVac.Enum.Gender;
import com.example.ProjectVac.Model.VaccinationCenter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class DoctorRequestDTO {
    int phone;
    String name;
    String email;
    Gender gender;
    int age;
    int centerId;
}
