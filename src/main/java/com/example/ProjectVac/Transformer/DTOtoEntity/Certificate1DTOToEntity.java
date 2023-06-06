package com.example.ProjectVac.Transformer.DTOtoEntity;

import com.example.ProjectVac.DTO.RequestDTO.Certificate1RequestDTO;
import com.example.ProjectVac.Model.Appointment;
import com.example.ProjectVac.Model.CertificateDose1;

import java.util.UUID;

public class Certificate1DTOToEntity {
    public static CertificateDose1 certificate1DTOToEntity(Certificate1RequestDTO certReq, Appointment appToAdd){
        return CertificateDose1.builder()
                .certificateID(UUID.randomUUID().toString())
                .doseTaken(certReq.isDoseTaken())
                .app(appToAdd)
                .build();
    }
}
