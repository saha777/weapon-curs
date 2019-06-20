package com.weapon.controllers;

import com.weapon.entities.Weapon;
import com.weapon.repositories.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weapons")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponRepository weaponRepository;

    @GetMapping
    public List<Weapon> getAll() {
        return weaponRepository.findAll();
    }

    @GetMapping("/modifications/{modificationId}")
    public List<Weapon> getByModificationId(@PathVariable Integer modificationId) {
        return weaponRepository.findByModificationId(modificationId);
    }

    @GetMapping("/creators/{creatorId}")
    public List<Weapon> getByCreatorId(@PathVariable Integer creatorId) {
        return weaponRepository.findByCreatorId(creatorId);
    }

    @GetMapping("/{id}")
    public Weapon getById(@PathVariable Integer id) {
        return findById(id);
    }

    @PostMapping
    public Weapon create(@RequestBody Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    @PutMapping
    public Weapon update(@RequestBody Weapon weapon) {
        findById(weapon.getId());
        return weaponRepository.save(weapon);
    }

    @DeleteMapping("/{id}")
    public Weapon delete(@PathVariable Integer id) {
        Weapon weapon = findById(id);
        weaponRepository.delete(weapon);
        return weapon;
    }

    private Weapon findById(Integer id) {
        return weaponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found entity by id"));
    }
}
