package com.weapon.controllers;

import com.weapon.clients.ModificationClient;
import com.weapon.dto.Modification;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/modifications")
@RequiredArgsConstructor
public class ModificationController {

    private final ModificationClient modificationClient;

    @GetMapping
    public List<Modification> getAll() {
        return modificationClient.getAll();
    }

    @GetMapping("/{id}")
    public Modification getById(@PathVariable Integer id) {
        return modificationClient.getById(id);
    }

    @PostMapping
    public Modification create(@RequestBody Modification modification) {
        return modificationClient.create(modification);
    }

    @PutMapping
    public Modification update(@RequestBody Modification modification) {
        return modificationClient.update(modification);
    }

    @DeleteMapping("/{id}")
    public Modification delete(@PathVariable Integer id) {
        return modificationClient.delete(id);
    }
}
