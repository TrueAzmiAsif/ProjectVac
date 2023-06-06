package com.example.ProjectVac.Model;

import com.example.ProjectVac.Enum.DoseNo;
import com.example.ProjectVac.Enum.Vaccine;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String doc_name;
    String center_name;
    String location;
    @CreationTimestamp
    Date date_of_book;
    Vaccine vac_name;
    DoseNo dose_num;
    Date ap_date;
    @ManyToOne
    @JoinColumn
    User user;
    @ManyToOne
    @JoinColumn
    Doctor doc;
    @ManyToOne
    @JoinColumn
    VaccinationCenter center;
    @OneToOne(mappedBy = "app",cascade = CascadeType.ALL)
    CertificateDose1 cert1;
    @OneToOne(mappedBy = "app",cascade = CascadeType.ALL)
    CertificateDose1 cert2;
}
