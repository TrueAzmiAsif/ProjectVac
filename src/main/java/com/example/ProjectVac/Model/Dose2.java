package com.example.ProjectVac.Model;

import com.example.ProjectVac.Enum.Vaccine;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dose2 {
    @Id
    int id;
    Vaccine Vac_name;
    Date date;
    String Vac_id;
    @OneToOne
    @JoinColumn
    User user;
}
