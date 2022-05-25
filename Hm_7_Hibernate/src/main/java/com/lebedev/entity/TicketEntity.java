package com.lebedev.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class TicketEntity {
    @Id
    private Long id;
    private Integer cost;
    private Boolean isSold;
    private LocalDateTime date;
    private MovieEntity movie;
    private PlaceEntity place;
}
