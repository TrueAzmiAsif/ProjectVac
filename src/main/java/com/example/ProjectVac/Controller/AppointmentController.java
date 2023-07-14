package com.example.ProjectVac.Controller;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.AppointmentResponseDTO;
import com.example.ProjectVac.Exception.CenterNotFoundException;
import com.example.ProjectVac.Exception.DoctorNotFoundException;
import com.example.ProjectVac.Exception.UserNotFoundException;
import com.example.ProjectVac.Service.Implementation.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentServiceImpl apServ;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody AppointmentRequestDTO apReq) throws ParseException {
        AppointmentResponseDTO apResp;
        try{
            apResp=apServ.add(apReq);
        }
        catch(DoctorNotFoundException e){
            return new ResponseEntity(e,HttpStatus.FORBIDDEN);
        }
        catch(CenterNotFoundException e){
            return new ResponseEntity(e,HttpStatus.FORBIDDEN);
        }
        catch(UserNotFoundException e){
            return new ResponseEntity(e,HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(apResp,HttpStatus.CREATED);
    }
}
