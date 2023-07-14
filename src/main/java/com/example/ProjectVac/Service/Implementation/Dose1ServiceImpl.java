package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.Enum.Vaccine;
import com.example.ProjectVac.Model.Dose1;
import com.example.ProjectVac.Model.User;
import com.example.ProjectVac.Repository.Dose1Repository;
import com.example.ProjectVac.Service.Dose1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class Dose1ServiceImpl implements Dose1Service {
    public Dose1 newDose(Vaccine vacName, Date date,User user){
        return Dose1.builder()
                .Vac_name(vacName)
                .Vac_id(UUID.randomUUID().toString())
                .date(date)
                .user(user)
                .build();
    }
}
