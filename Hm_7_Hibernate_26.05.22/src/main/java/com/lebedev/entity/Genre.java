package com.lebedev.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
@Data
public class Genre {
    @Id
    private Long id;

    private String name;
}
