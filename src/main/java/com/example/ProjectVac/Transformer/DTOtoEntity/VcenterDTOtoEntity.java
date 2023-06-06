package com.example.ProjectVac.Transformer.DTOtoEntity;

import com.example.ProjectVac.DTO.RequestDTO.VcenterRequestDTO;
import com.example.ProjectVac.Model.VaccinationCenter;

import java.util.UUID;

public class VcenterDTOtoEntity {
    public static VaccinationCenter vcenterDTOtoEntity(VcenterRequestDTO vcReq){
        return VaccinationCenter.builder()
                .type(vcReq.getType())
                .location(vcReq.getLocation())
                .name(vcReq.getName())
                .CenterId(UUID.randomUUID().toString())
                .build();
    }
}
