package com.lebedev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceEntity {
    private Long id;
    private Integer number;
    private Integer row;
    private String hall;
}
