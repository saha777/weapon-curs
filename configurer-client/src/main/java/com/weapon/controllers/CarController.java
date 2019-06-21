package com.weapon.controllers;

import com.weapon.clients.CarClient;
import com.weapon.dto.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarClient carClient;

    @GetMapping
    public List<Car> getAll() {
        return carClient.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id) {
        return carClient.getById(id);
    }

    @GetMapping("/configurations/{configurationId}")
    public List<Car> getByConfigurationId(@PathVariable Integer configurationId) {
        return carClient.getByConfigurationId(configurationId);
    }

    @GetMapping("/creators/{creatorId}")
    public List<Car> getByCreatorId(@PathVariable Integer creatorId) {
        return carClient.getByCreatorId(creatorId);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public Car create(@RequestBody Car car) {
        return carClient.create(car);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping
    public Car update(@RequestBody Car car) {
        return carClient.update(car);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public Car delete(@PathVariable Integer id) {
        return carClient.delete(id);
    }
}
