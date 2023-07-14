package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.AppointmentResponseDTO;
import com.example.ProjectVac.Enum.DoseNo;
import com.example.ProjectVac.Exception.CenterNotFoundException;
import com.example.ProjectVac.Exception.DoctorNotFoundException;
import com.example.ProjectVac.Exception.UserNotFoundException;
import com.example.ProjectVac.Model.*;
import com.example.ProjectVac.Repository.*;
import com.example.ProjectVac.Service.AppointmentService;
import com.example.ProjectVac.Transformer.DTOtoEntity.AppointmentDTOToEntity;
import com.example.ProjectVac.Transformer.EntityToDTO.EntityToAppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {
//    @Autowired
//    AppointmentRepository appRep;
    @Autowired
    UserRepository usRep;
    @Autowired
    DoctorRepository docRep;
    @Autowired
    Dose1ServiceImpl dose1serv;
    @Autowired
    Dose2ServiceImpl dose2serv;
    public AppointmentResponseDTO add(AppointmentRequestDTO appReq) throws DoctorNotFoundException, CenterNotFoundException, UserNotFoundException, ParseException {
        //Optional<Doctor> doc=docReq.findById(appReq.getDocId());
        DoseNo dose;
        Appointment app;
        Doctor doc;
        User userToSave;
//        VaccinationCenter center=vcRep.findByLocationAndName(appReq.getLocation(),appReq.getCenterName());
        Optional<User> user=usRep.findById(appReq.getUserId());
        Optional<Doctor> optDoc=docRep.findById(appReq.getDocId());
//        if(center==null)
//            throw new CenterNotFoundException("OOPS! Center not found");
        if(user.isEmpty())
            throw new UserNotFoundException("OOPS! User not found");
        else if(optDoc.isEmpty())
            throw new DoctorNotFoundException("OOPS! Doctor not found");
        else{
            doc=optDoc.get();
            userToSave=user.get();
//            List<Doctor> docList=center.getDoc();
//            doc=docList.get((int)Math.random() * docList.size());
            if(userToSave.isDose1Taken())
                dose=DoseNo.DOSE2;
            else dose=DoseNo.DOSE1;
            app= AppointmentDTOToEntity.appointmentDTOToEntity(appReq,doc,dose,doc.getCenter(),userToSave);
        }
//        System.out.println(app.getAp_date());
        doc.getApp().add(app);
        //userToSave=user.get();
        userToSave.getApp().add(app);
        if(dose==DoseNo.DOSE1)
            userToSave.setDose1(dose1serv.newDose(appReq.getVacName(),app.getAp_date(),userToSave));
        else
            userToSave.setDose2(dose2serv.newDose(appReq.getVacName(),app.getAp_date(),userToSave));
//        center.getApp().add(app);
        usRep.save(userToSave);
        return EntityToAppointmentDTO.entityToAppointmentDTO(app);
    }
}
