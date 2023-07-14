package com.example.ProjectVac.Service;

import com.example.ProjectVac.DTO.RequestDTO.CertificateRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.CertificateResponseDTO;
import com.example.ProjectVac.Exception.AppointmentNotFoundException;

public interface CertificateService {
    public CertificateResponseDTO generate(CertificateRequestDTO certReq)throws AppointmentNotFoundException;
}
