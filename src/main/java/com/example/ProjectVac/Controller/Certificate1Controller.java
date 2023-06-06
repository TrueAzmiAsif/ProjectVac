package com.example.ProjectVac.Controller;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.DTO.RequestDTO.Certificate1RequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.Certificate1ResponseDTO;
import com.example.ProjectVac.Exception.AppointmentNotFoundException;
import com.example.ProjectVac.Model.CertificateDose1;
import com.example.ProjectVac.Service.Implementation.AppointmentServiceImpl;
import com.example.ProjectVac.Service.Implementation.Certificate1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate1")
public class Certificate1Controller {
    @Autowired
    Certificate1ServiceImpl certServ;
    @PostMapping("/generate")
    public ResponseEntity generate(@RequestBody Certificate1RequestDTO certReq) {
        Certificate1ResponseDTO cert;
        try{
            cert=certServ.generate(certReq);
        }
        catch(AppointmentNotFoundException e){
            return new ResponseEntity(e, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(cert, HttpStatus.FORBIDDEN);
    }
}
