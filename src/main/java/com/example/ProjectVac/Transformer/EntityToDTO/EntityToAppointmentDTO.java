package com.example.ProjectVac.Transformer.EntityToDTO;

import com.example.ProjectVac.DTO.ResponseDTO.AppointmentResponseDTO;
import com.example.ProjectVac.Model.Appointment;

public class EntityToAppointmentDTO {
    public static AppointmentResponseDTO entityToAppointmentDTO(Appointment app){
        return AppointmentResponseDTO.builder()
                .UserName(app.getUser().getName())
                .gender(app.getUser().getGender().toString())
                .phone(app.getUser().getPhone())
                .centerName(app.getCenter_name())
                .location(app.getLocation())
                .docName(app.getDoc_name())
                .vaccineName(app.getVac_name().toString())
                .doseNumber(app.getDose_num().toString())
                .appDate(app.getAp_date())
                .bookDate(app.getDate_of_book())
                .build();
    }
}
