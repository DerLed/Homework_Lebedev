package com.lebedev.entity;

import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;
}
