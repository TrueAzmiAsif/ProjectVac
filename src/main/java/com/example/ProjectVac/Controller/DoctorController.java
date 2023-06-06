package com.example.ProjectVac.Controller;

import com.example.ProjectVac.DTO.RequestDTO.DoctorRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.DoctorResponseDTO;
import com.example.ProjectVac.Exception.CenterNotFoundException;
import com.example.ProjectVac.Service.Implementation.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorServiceImpl docServ;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody DoctorRequestDTO docReq){
        DoctorResponseDTO resp=null;
        try {
            resp=docServ.add(docReq);
        }
        catch(CenterNotFoundException e){
            return new ResponseEntity(resp,HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(resp,HttpStatus.CREATED);
    }
}
