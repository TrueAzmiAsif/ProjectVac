package com.example.ProjectVac.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CertificateDose1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    boolean doseTaken;
    String certificateID;
    @OneToOne
    @JoinColumn
    Appointment app;
}
