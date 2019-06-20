package com.weapon.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "creators")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String country;
}
