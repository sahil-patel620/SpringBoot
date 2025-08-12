package com.week3.HospitalManagementSystem.dto;

import com.week3.HospitalManagementSystem.entities.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private  final Long count;
}
