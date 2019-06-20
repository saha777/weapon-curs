package com.weapon.repositories;

import com.weapon.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
    List<Weapon> findByModificationId(Integer modificationId);
    List<Weapon> findByCreatorId(Integer creatorId);
}
