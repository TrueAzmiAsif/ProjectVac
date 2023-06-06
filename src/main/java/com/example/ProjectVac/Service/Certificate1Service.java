package com.example.ProjectVac.Service;

import com.example.ProjectVac.DTO.RequestDTO.Certificate1RequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.Certificate1ResponseDTO;
import com.example.ProjectVac.Exception.AppointmentNotFoundException;

public interface Certificate1Service {
    public Certificate1ResponseDTO generate(Certificate1RequestDTO certReq)throws AppointmentNotFoundException;
}
