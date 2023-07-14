package com.example.ProjectVac.Model;

import com.example.ProjectVac.Enum.DoseNo;
import com.example.ProjectVac.Enum.Vaccine;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

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
//    String center_name;
//    String location;
    @CreationTimestamp
    Date date_of_book;
    @Enumerated(value = EnumType.STRING)
    Vaccine vac_name;
    @Enumerated(value = EnumType.STRING)
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
    @OneToMany(mappedBy = "app",cascade = CascadeType.ALL)
    List<Certificate> certificate;
}
