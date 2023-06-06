package com.example.ProjectVac.Service;

import com.example.ProjectVac.DTO.RequestDTO.AppointmentRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.AppointmentResponseDTO;
import com.example.ProjectVac.Exception.CenterNotFoundException;
import com.example.ProjectVac.Exception.DoctorNotFoundException;
import com.example.ProjectVac.Exception.UserNotFoundException;

public interface AppointmentService {
    public AppointmentResponseDTO add(AppointmentRequestDTO appReq)throws DoctorNotFoundException, CenterNotFoundException, UserNotFoundException;
}
