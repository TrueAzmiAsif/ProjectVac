package com.example.ProjectVac.Transformer.EntityToDTO;

import com.example.ProjectVac.DTO.ResponseDTO.CertificateResponseDTO;
import com.example.ProjectVac.Model.Certificate;
import com.example.ProjectVac.Model.User;

public class EntityToCertificateResponseDTO {
    public static CertificateResponseDTO entityToCertificate1ResponseDTO(Certificate certReq, User us){
        return CertificateResponseDTO.builder()
                .name(certReq.getApp().getUser().getName())
                .gender(certReq.getApp().getUser().getGender().toString())
                .phone(certReq.getApp().getUser().getPhone())
                .certificateID(certReq.getCertificateID())
                .vaccineName(certReq.getApp().getVac_name().toString())
                .vaccineId(us.getDose1().getVac_id())
                .centerName(certReq.getApp().getCenter().getName())
                .cenetrId(certReq.getApp().getCenter().getCenterId())
                .build();
    }
}
