package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.Enum.Vaccine;
import com.example.ProjectVac.Model.Dose1;
import com.example.ProjectVac.Model.Dose2;
import com.example.ProjectVac.Model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class Dose2ServiceImpl {
    public Dose2 newDose(Vaccine vacName, Date date, User user){
        return Dose2.builder()
                .Vac_name(vacName)
                .Vac_id(UUID.randomUUID().toString())
                .date(date)
                .user(user)
                .build();
    }
}
