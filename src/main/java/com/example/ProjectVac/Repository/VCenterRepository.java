package com.example.ProjectVac.Repository;

import com.example.ProjectVac.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
