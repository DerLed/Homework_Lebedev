package com.lebedev.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TicketEntity {
    private Long id;
    private Integer cost;
    private Boolean isSold;
    private LocalDateTime date;
    private MovieEntity movie;
    private PlaceEntity place;
}
