package com.example.ProjectVac.Transformer.DTOtoEntity;

import com.example.ProjectVac.DTO.RequestDTO.DoctorRequestDTO;
import com.example.ProjectVac.Model.Doctor;
import com.example.ProjectVac.Model.VaccinationCenter;

public class DoctorDTOToEntity {
    public static Doctor doctorDTOToEntity(DoctorRequestDTO docReq, VaccinationCenter cent){
        return Doctor.builder()
                .name(docReq.getName())
                .age(docReq.getAge())
                .phone(docReq.getPhone())
                .email(docReq.getEmail())
                .gender(docReq.getGender())
                .center(cent)
                .build();
    }
}
