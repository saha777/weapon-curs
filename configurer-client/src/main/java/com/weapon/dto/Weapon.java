package com.weapon.dto;

import lombok.Data;

@Data
public class Weapon {
    private Integer id;
    private String name;
    private Creator creator;
    private Modification modification;
}
