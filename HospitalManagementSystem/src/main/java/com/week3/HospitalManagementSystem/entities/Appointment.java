package com.week3.HospitalManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private  String reason;

    @ManyToOne  // When you load the parent entity, Hibernate will immediately load the related entity at the same time. to stop this use (fetch = Fetch.Type = EAGER)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore   //Prevent a field or method from being included in the JSON output. Prevent Jackson from looking for the field when parsing JSON input (unless you allow it via other configs).
    private Patient patient; // Owning Side

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Doctor doctor;    // Owning Side
}
