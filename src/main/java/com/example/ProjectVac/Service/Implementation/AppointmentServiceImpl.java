package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.AppointmentResponseDTO;
import com.example.ProjectVac.Enum.DoseNo;
import com.example.ProjectVac.Exception.CenterNotFoundException;
import com.example.ProjectVac.Exception.DoctorNotFoundException;
import com.example.ProjectVac.Exception.UserNotFoundException;
import com.example.ProjectVac.Model.Appointment;
import com.example.ProjectVac.Model.Doctor;
import com.example.ProjectVac.Model.User;
import com.example.ProjectVac.Model.VaccinationCenter;
import com.example.ProjectVac.Repository.AppointmentRepository;
import com.example.ProjectVac.Repository.DoctorRepository;
import com.example.ProjectVac.Repository.UserRepository;
import com.example.ProjectVac.Repository.VCenterRepository;
import com.example.ProjectVac.Service.AppointmentService;
import com.example.ProjectVac.Transformer.DTOtoEntity.AppointmentDTOToEntity;
import com.example.ProjectVac.Transformer.EntityToDTO.EntityToAppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appRep;
    @Autowired
    DoctorRepository docReq;
    @Autowired
    UserRepository usRep;
    @Autowired
    VCenterRepository vcRep;
    public AppointmentResponseDTO add(AppointmentRequestDTO appReq)throws DoctorNotFoundException,CenterNotFoundException,UserNotFoundException{
        //Optional<Doctor> doc=docReq.findById(appReq.getDocId());
        DoseNo dose;
        Appointment app;
        Doctor doc;
        Optional<VaccinationCenter> center=vcRep.findById(appReq.getCenter().getId());
        Optional<User> user=usRep.findById(appReq.getUser().getId());
        if(center.isEmpty())
            throw new CenterNotFoundException("OOPS! Center not found");
        else if(user.isEmpty())
            throw new UserNotFoundException("OOPS! User not found");
        else if(center.get().getDoc().isEmpty())
            throw new DoctorNotFoundException("OOPS! Doctor not found");
        else{
            List<Doctor> docList=center.get().getDoc();
            doc=docList.get((int)Math.random() * docList.size());
            if(user.get().isDose1Taken())
                dose=DoseNo.DOSE2;
            else dose=DoseNo.DOSE1;
            app= AppointmentDTOToEntity.appointmentDTOToEntity(appReq,doc,dose);
        }
        doc.getApp().add(app);
        docReq.save(doc);
        User userToSave=user.get();
        userToSave.getApp().add(app);
        usRep.save(userToSave);
        return EntityToAppointmentDTO.entityToAppointmentDTO(app);
    }
}
