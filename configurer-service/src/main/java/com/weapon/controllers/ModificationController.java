package com.weapon.controllers;

import com.weapon.entities.Modification;
import com.weapon.repositories.ModificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modifications")
@RequiredArgsConstructor
public class ModificationController {

    private final ModificationRepository modificationRepository;

    @GetMapping
    public List<Modification> getAll() {
        return modificationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Modification getById(@PathVariable Integer id) {
        return findById(id);
    }

    @PostMapping
    public Modification create(@RequestBody Modification modification) {
        return modificationRepository.save(modification);
    }

    @PutMapping
    public Modification update(@RequestBody Modification modification) {
        findById(modification.getId());
        return modificationRepository.save(modification);
    }

    @DeleteMapping("/{id}")
    public Modification delete(@PathVariable Integer id) {
        Modification modification = findById(id);
        modificationRepository.delete(modification);
        return modification;
    }

    private Modification findById(Integer id) {
        return modificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found entity by id"));
    }
}
