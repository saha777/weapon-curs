package com.weapon.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "creators")
public class Modification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String soundModerator;
    private String aim;
    private String customDetails;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    private Creator creator;
}
