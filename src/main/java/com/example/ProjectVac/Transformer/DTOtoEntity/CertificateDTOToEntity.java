package com.example.ProjectVac.Transformer.DTOtoEntity;

import com.example.ProjectVac.DTO.RequestDTO.CertificateRequestDTO;
import com.example.ProjectVac.Model.Appointment;
import com.example.ProjectVac.Model.Certificate;

import java.util.UUID;

public class CertificateDTOToEntity {
    public static Certificate certificate1DTOToEntity(CertificateRequestDTO certReq, Appointment appToAdd){
        return Certificate.builder()
                .certificateID(UUID.randomUUID().toString())
                .doseTaken(certReq.isDoseTaken())
                .app(appToAdd)
                .build();
    }
}
