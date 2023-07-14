package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.CertificateRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.CertificateResponseDTO;
import com.example.ProjectVac.Exception.AppointmentNotFoundException;
import com.example.ProjectVac.Model.*;
import com.example.ProjectVac.Repository.AppointmentRepository;
import com.example.ProjectVac.Repository.UserRepository;
import com.example.ProjectVac.Service.CertificateService;
import com.example.ProjectVac.Transformer.DTOtoEntity.CertificateDTOToEntity;
import com.example.ProjectVac.Transformer.EntityToDTO.EntityToCertificateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    AppointmentRepository appRep;
    @Autowired
    UserRepository usRep;
    @Override
    public CertificateResponseDTO generate(CertificateRequestDTO certReq)throws AppointmentNotFoundException {
        Certificate cert=null;
        Appointment ap;
        User us=null;
        Dose1 do1;
        if(certReq.isDoseTaken()){
            Optional<Appointment> opAp=appRep.findById(certReq.getAppId());
            if(opAp.isEmpty())
                throw new AppointmentNotFoundException("Appointment not found!");
            ap=opAp.get();
            cert= CertificateDTOToEntity.certificate1DTOToEntity(certReq,ap);
            //ap=cert.getApp();
            us=ap.getUser();
            ap.getCertificate().add(cert);
            if(!us.isDose1Taken())
                us.setDose1Taken(true);
            else if(!us.isDose2Taken())
                us.setDose2Taken(true);
//            do1=new Dose1();
//            do1.setDate(ap.getAp_date());
//            do1.setVac_id(UUID.randomUUID().toString());
//            do1.setVac_name(ap.getVac_name());
//            do1.setUser(us);
//            appRep.save(ap);
        }
        else{
            if(!us.isDose1Taken()){
                Dose1 dose1=us.getDose1();
                dose1=null;
                us.setDose1(dose1);
            }
            else if(!us.isDose2Taken()){
                Dose2 dose2=us.getDose2();
                dose2=null;
                us.setDose2(dose2);
            }
        }
        usRep.save(us);
        return EntityToCertificateResponseDTO.entityToCertificate1ResponseDTO(cert,us);
    }
}
