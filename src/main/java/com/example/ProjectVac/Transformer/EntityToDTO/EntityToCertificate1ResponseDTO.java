package com.example.ProjectVac.Transformer.EntityToDTO;

import com.example.ProjectVac.DTO.ResponseDTO.Certificate1ResponseDTO;
import com.example.ProjectVac.Model.CertificateDose1;
import com.example.ProjectVac.Model.User;

public class EntityToCertificate1ResponseDTO {
    public static Certificate1ResponseDTO entityToCertificate1ResponseDTO(CertificateDose1 certReq, User us){
        return Certificate1ResponseDTO.builder()
                .name(certReq.getApp().getUser().getName())
                .gender(certReq.getApp().getUser().getGender().toString())
                .phone(certReq.getApp().getUser().getPhone())
                .certificateID(certReq.getCertificateID())
                .vaccineName(certReq.getApp().getVac_name().toString())
                .vaccineId(us.getDose1().getVac_id())
                .centerName(certReq.getApp().getCenter_name())
                .cenetrId(certReq.getApp().getCenter().getCenterId())
                .build();
    }
}
