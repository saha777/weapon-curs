package com.weapon.controllers;

import com.weapon.clients.WeaponClient;
import com.weapon.dto.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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

    @GetMapping("/modifications/{modificationId}")
    public List<Weapon> getByModificationId(@PathVariable Integer modificationId) {
        return weaponClient.getByModificationId(modificationId);
    }

    @GetMapping("/creators/{creatorId}")
    public List<Weapon> getByCreatorId(@PathVariable Integer creatorId) {
        return weaponClient.getByCreatorId(creatorId);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public Weapon create(@RequestBody Weapon weapon) {
        return weaponClient.create(weapon);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping
    public Weapon update(@RequestBody Weapon weapon) {
        return weaponClient.update(weapon);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public Weapon delete(@PathVariable Integer id) {
        return weaponClient.delete(id);
    }
}
