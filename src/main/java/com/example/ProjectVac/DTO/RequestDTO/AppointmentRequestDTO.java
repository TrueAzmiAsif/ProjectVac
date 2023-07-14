package com.example.ProjectVac.DTO.RequestDTO;

import com.example.ProjectVac.Enum.DoseNo;
import com.example.ProjectVac.Enum.Gender;
import com.example.ProjectVac.Enum.Vaccine;
import com.example.ProjectVac.Model.User;
import com.example.ProjectVac.Model.VaccinationCenter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AppointmentRequestDTO {
//    String centerName;
//    String location;
    String date;
    Vaccine vacName;
    int userId;
    int docId;
}
