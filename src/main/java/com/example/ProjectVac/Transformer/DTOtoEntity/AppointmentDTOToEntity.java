package com.example.ProjectVac.Transformer.DTOtoEntity;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.Enum.DoseNo;
import com.example.ProjectVac.Model.Appointment;
import com.example.ProjectVac.Model.Doctor;

public class AppointmentDTOToEntity {
    public static Appointment appointmentDTOToEntity(AppointmentRequestDTO appReq, Doctor doc, DoseNo dose){
        return Appointment.builder()
                .center_name(appReq.getCenterName())
                .location(appReq.getLocation())
                .vac_name(appReq.getVacName())
                .ap_date(appReq.getDOAp())
                .user(appReq.getUser())
                .center(appReq.getCenter())
                .doc_name(doc.getName())
                .doc(doc)
                .dose_num(dose)
                .build();
    }
}
