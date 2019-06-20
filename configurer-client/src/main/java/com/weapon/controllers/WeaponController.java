package com.weapon.controllers;

import com.weapon.clients.WeaponClient;
import com.weapon.dto.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weapons")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponClient weaponClient;

    @GetMapping
    public List<Weapon> getAll() {
        return weaponClient.getAll();
    }

    @GetMapping("/{id}")
    public Weapon getById(@PathVariable Integer id) {
        return weaponClient.getById(id);
    }

    @PostMapping
    public Weapon create(@RequestBody Weapon weapon) {
        return weaponClient.create(weapon);
    }

    @PutMapping
    public Weapon update(@RequestBody Weapon weapon) {
        return weaponClient.update(weapon);
    }

    @DeleteMapping("/{id}")
    public Weapon delete(@PathVariable Integer id) {
        return weaponClient.delete(id);
    }
}
