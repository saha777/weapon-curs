package com.weapon.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;

    @ManyToOne
    @JoinColumn(name = "modification_id")
    private Modification modification;
}
