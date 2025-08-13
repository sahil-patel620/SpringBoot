package com.week3.HospitalManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private  String reason;

    private  String status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient; // Owning Side

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;    // Owning Side
}
