package com.weapon.repositories;

import com.weapon.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
}
