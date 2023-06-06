package com.example.ProjectVac.Transformer.EntityToDTO;

import com.example.ProjectVac.DTO.ResponseDTO.DoctorResponseDTO;
import com.example.ProjectVac.Model.Doctor;

public class EntityToDoctorDTO {
    public static DoctorResponseDTO entityToDoctorDTO(Doctor doc, String message){
        return DoctorResponseDTO.builder()
                .name(doc.getName())
                .centerName(doc.getCenter().getName())
                .centerID(doc.getCenter().getCenterId())
                .message(message)
                .location(doc.getCenter().getLocation())
                .build();
    }
}
