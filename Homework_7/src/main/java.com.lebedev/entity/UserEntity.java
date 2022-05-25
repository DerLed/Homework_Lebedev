package com.lebedev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserEntity {
    private Long id;
    private String name;
    private String email;
    private List<TicketEntity> tickets = new ArrayList<>();

    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
