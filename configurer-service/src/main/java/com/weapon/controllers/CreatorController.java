package com.weapon.controllers;

import com.weapon.entities.Creator;
import com.weapon.repositories.CreatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creators")
@RequiredArgsConstructor
public class CreatorController {

    private final CreatorRepository creatorRepository;

    @GetMapping
    public List<Creator> getAll() {
        return creatorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Creator getById(@PathVariable Integer id) {
        return findById(id);
    }

    @PostMapping
    public Creator create(@RequestBody Creator creator) {
        return creatorRepository.save(creator);
    }

    @PutMapping
    public Creator update(@RequestBody Creator creator) {
        findById(creator.getId());
        return creatorRepository.save(creator);
    }

    @DeleteMapping("/{id}")
    public Creator delete(@PathVariable Integer id) {
        Creator creator = findById(id);
        creatorRepository.delete(creator);
        return creator;
    }

    private Creator findById(Integer id) {
        return creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found entity by id"));
    }
}
