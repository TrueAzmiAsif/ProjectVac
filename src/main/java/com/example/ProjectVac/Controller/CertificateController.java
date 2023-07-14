package com.example.ProjectVac.Controller;

import com.example.ProjectVac.DTO.RequestDTO.CertificateRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.CertificateResponseDTO;
import com.example.ProjectVac.Exception.AppointmentNotFoundException;
import com.example.ProjectVac.Service.Implementation.CertificateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate1")
public class CertificateController {
    @Autowired
    CertificateServiceImpl certServ;
    @PostMapping("/generate")
    public ResponseEntity generate(@RequestBody CertificateRequestDTO certReq) {
        CertificateResponseDTO cert;
        try{
            cert=certServ.generate(certReq);
        }
        catch(AppointmentNotFoundException e){
            return new ResponseEntity(e, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(cert, HttpStatus.FORBIDDEN);
    }
}
