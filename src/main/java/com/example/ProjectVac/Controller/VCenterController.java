package com.example.ProjectVac.Controller;

import com.example.ProjectVac.DTO.RequestDTO.VcenterRequestDTO;
import com.example.ProjectVac.Service.Implementation.VCenterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VCenterController {
    @Autowired
    VCenterServiceImpl vcs;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody VcenterRequestDTO vcReq){
        return new ResponseEntity(vcs.add(vcReq), HttpStatus.CREATED);
    }
}
