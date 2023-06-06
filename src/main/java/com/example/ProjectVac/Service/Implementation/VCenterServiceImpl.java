package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.VcenterRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.VCenterResponseDTO;
import com.example.ProjectVac.Model.VaccinationCenter;
import com.example.ProjectVac.Repository.VCenterRepository;
import com.example.ProjectVac.Transformer.DTOtoEntity.VcenterDTOtoEntity;
import com.example.ProjectVac.Transformer.EntityToDTO.EntityToVcenterResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VCenterServiceImpl {
    @Autowired
    VCenterRepository vcRepo;
    public VCenterResponseDTO add(VcenterRequestDTO vcr){
        VaccinationCenter vac= VcenterDTOtoEntity.vcenterDTOtoEntity(vcr);
        return EntityToVcenterResponseDTO.entityToVcenterResponseDTO(vcRepo.save(vac), "Has been added successfully.");
    }
}
