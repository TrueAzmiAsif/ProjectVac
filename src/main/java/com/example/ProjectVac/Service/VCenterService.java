package com.example.ProjectVac.Service;

import com.example.ProjectVac.DTO.RequestDTO.VcenterRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.VCenterResponseDTO;

public interface VCenterService {
    public VCenterResponseDTO add(VcenterRequestDTO vcr);
}
