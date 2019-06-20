package com.weapon.controllers;

import com.weapon.clients.CreatorClient;
import com.weapon.dto.Creator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creators")
@RequiredArgsConstructor
public class CreatorController {

    private final CreatorClient creatorClient;

    @GetMapping
    public List<Creator> getAll() {
        return creatorClient.getAll();
    }

    @GetMapping("/{id}")
    public Creator getById(@PathVariable Integer id) {
        return creatorClient.getById(id);
    }

    @PostMapping
    public Creator create(@RequestBody Creator creator) {
        return creatorClient.create(creator);
    }

    @PutMapping
    public Creator update(@RequestBody Creator creator) {
        return creatorClient.update(creator);
    }

    @DeleteMapping("/{id}")
    public Creator delete(@PathVariable Integer id) {
        return creatorClient.delete(id);
    }
}

