package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.Certificate1RequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.Certificate1ResponseDTO;
import com.example.ProjectVac.Exception.AppointmentNotFoundException;
import com.example.ProjectVac.Model.Appointment;
import com.example.ProjectVac.Model.CertificateDose1;
import com.example.ProjectVac.Model.Dose1;
import com.example.ProjectVac.Model.User;
import com.example.ProjectVac.Repository.AppointmentRepository;
import com.example.ProjectVac.Repository.UserRepository;
import com.example.ProjectVac.Service.Certificate1Service;
import com.example.ProjectVac.Transformer.DTOtoEntity.Certificate1DTOToEntity;
import com.example.ProjectVac.Transformer.EntityToDTO.EntityToCertificate1ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class Certificate1ServiceImpl implements Certificate1Service {
    @Autowired
    AppointmentRepository appRep;
    @Autowired
    UserRepository usRep;
    @Override
    public Certificate1ResponseDTO generate(Certificate1RequestDTO certReq)throws AppointmentNotFoundException {
        CertificateDose1 cert=null;
        Appointment ap;
        User us=null;
        Dose1 do1;
        if(certReq.isDoseTaken()){
            Optional<Appointment> opAp=appRep.findById(certReq.getAppId());
            if(opAp.isEmpty())
                throw new AppointmentNotFoundException("Appointment not found!");
            cert= Certificate1DTOToEntity.certificate1DTOToEntity(certReq,opAp.get());
            ap=cert.getApp();
            us=ap.getUser();
            us.setDose1Taken(true);
            do1=new Dose1();
            do1.setDate(ap.getAp_date());
            do1.setVac_id(UUID.randomUUID().toString());
            do1.setVac_name(ap.getVac_name());
            do1.setUser(us);
            usRep.save(us);
            appRep.save(ap);
        }
        return EntityToCertificate1ResponseDTO.entityToCertificate1ResponseDTO(cert,us);
    }
}
