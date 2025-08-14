package com.week3.HospitalManagementSystem.entities;

import com.week3.HospitalManagementSystem.entities.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;

    private LocalDate  birthDate;

    private  String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_insurance" , unique = true)
    private Insurance insurance; // Owning Side

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)    // by defining cascade = CascadeType.ALL whenever Patient is deleted it will also delete the all the appointments related to that patient.
//    @ToString.Exclude
    private Set<Appointment> appointments = new HashSet<>();   // Inverse side
}
