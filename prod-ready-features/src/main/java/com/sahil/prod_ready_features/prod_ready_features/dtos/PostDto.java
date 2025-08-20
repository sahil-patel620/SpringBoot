package com.sahil.prod_ready_features.prod_ready_features.dtos;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private  Long id;
    private String title;
    private String description;
}
