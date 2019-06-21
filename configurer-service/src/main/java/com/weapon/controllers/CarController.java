package com.weapon.controllers;

import com.weapon.entities.Car;
import com.weapon.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @GetMapping("/configurations/{configurationId}")
    public List<Car> getByConfigurationId(@PathVariable Integer configurationId) {
        return carRepository.findByConfigurationId(configurationId);
    }

    @GetMapping("/creators/{creatorId}")
    public List<Car> getByCreatorId(@PathVariable Integer creatorId) {
        return carRepository.findByCreatorId(creatorId);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id) {
        return findById(id);
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        findById(car.getId());
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public Car delete(@PathVariable Integer id) {
        Car car = findById(id);
        carRepository.delete(car);
        return car;
    }

    private Car findById(Integer id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found entity by id"));
    }
}
