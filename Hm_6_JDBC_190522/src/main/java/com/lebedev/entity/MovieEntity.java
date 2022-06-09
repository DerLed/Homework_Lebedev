package com.lebedev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieEntity {
    private Long id;
    private String title;
    private String description;
}
