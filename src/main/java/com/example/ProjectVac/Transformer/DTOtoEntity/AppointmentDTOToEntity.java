package com.example.ProjectVac.Transformer.DTOtoEntity;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.Enum.DoseNo;
import com.example.ProjectVac.Model.Appointment;
import com.example.ProjectVac.Model.Doctor;
import com.example.ProjectVac.Model.User;
import com.example.ProjectVac.Model.VaccinationCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class AppointmentDTOToEntity {
    public static Appointment appointmentDTOToEntity(AppointmentRequestDTO appReq, Doctor doc, DoseNo dose, VaccinationCenter center, User user) throws ParseException {
        return Appointment.builder()
//                .center_name(appReq.getCenterName())
//                .location(appReq.getLocation())
                .vac_name(appReq.getVacName())
                .ap_date(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a", Locale.ENGLISH).parse(appReq.getDate()))
                .user(user)
                .center(center)
                .doc_name(doc.getName())
                .doc(doc)
                .dose_num(dose)
                .build();
    }
}
