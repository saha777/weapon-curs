package com.weapon.repositories;

import com.weapon.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByConfigurationId(Integer configurationId);
    List<Car> findByCreatorId(Integer creatorId);
}
