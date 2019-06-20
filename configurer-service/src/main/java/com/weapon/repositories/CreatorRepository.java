package com.weapon.repositories;

import com.weapon.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator, Integer> {
}
