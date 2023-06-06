package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.DoctorRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.DoctorResponseDTO;
import com.example.ProjectVac.Exception.CenterNotFoundException;
import com.example.ProjectVac.Model.Doctor;
import com.example.ProjectVac.Model.VaccinationCenter;
import com.example.ProjectVac.Repository.DoctorRepository;
import com.example.ProjectVac.Repository.VCenterRepository;
import com.example.ProjectVac.Transformer.DTOtoEntity.DoctorDTOToEntity;
import com.example.ProjectVac.Transformer.EntityToDTO.EntityToDoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl {
    @Autowired
    DoctorRepository docRep;
    @Autowired
    VCenterRepository vcRep;
    public DoctorResponseDTO add(DoctorRequestDTO docReq)throws CenterNotFoundException{
        Doctor doc;
        Optional<VaccinationCenter> opVac=vcRep.findById(docReq.getCenterId());
        if(opVac.isEmpty())
            throw new CenterNotFoundException("OOPS! Center not found.");
        VaccinationCenter cent=opVac.get();
        doc= DoctorDTOToEntity.doctorDTOToEntity(docReq,cent);
        cent.getDoc().add(doc);
        vcRep.save(cent);
        return EntityToDoctorDTO.entityToDoctorDTO(doc,"Added successfully!");
    }
}
