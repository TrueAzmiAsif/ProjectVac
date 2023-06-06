package com.example.ProjectVac.Model;

import com.example.ProjectVac.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "phone")
    int phone;

    @Column(name = "email")
    String email;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean dose1Taken,dose2Taken;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Appointment> app=new ArrayList<>();
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Dose1 dose1;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Dose2 dose2;
}
