package com.weapon.repositories;

import com.weapon.entities.Modification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModificationRepository extends JpaRepository<Modification, Integer> {
}
