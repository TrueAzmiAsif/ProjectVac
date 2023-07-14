package com.example.ProjectVac.Model;

import com.example.ProjectVac.Enum.Vaccine;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Dose2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Enumerated(value = EnumType.STRING)
    Vaccine Vac_name;
    Date date;
    String Vac_id;
    @OneToOne
    @JoinColumn
    User user;
}
