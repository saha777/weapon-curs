package com.weapon.dto;

import lombok.Data;

@Data
public class Car {
    private Integer id;
    private String name;
    private Creator creator;
    private Configuration configuration;
}
