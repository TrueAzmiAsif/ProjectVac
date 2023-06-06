package com.example.ProjectVac.Transformer.EntityToDTO;

import com.example.ProjectVac.DTO.ResponseDTO.VCenterResponseDTO;
import com.example.ProjectVac.Model.VaccinationCenter;

public class EntityToVcenterResponseDTO {
    public static VCenterResponseDTO entityToVcenterResponseDTO(VaccinationCenter vac,String message){
        return VCenterResponseDTO.builder()
                .centerId(vac.getCenterId())
                .name(vac.getName())
                .message(message)
                .build();
    }
}
