package com.example.ProjectVac.Model;

import com.example.ProjectVac.Enum.Center;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String CenterId;
    @Enumerated(EnumType.STRING)
    Center type;
    String location;
    String name;
    @OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
    List<Doctor> doc= new ArrayList<>();
    @OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
    List<Appointment> app= new ArrayList<>();
}
