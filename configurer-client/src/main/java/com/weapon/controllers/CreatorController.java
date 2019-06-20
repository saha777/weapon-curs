package com.weapon.controllers;

import com.weapon.clients.CreatorClient;
import com.weapon.dto.Creator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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

    @Secured("ROLE_ADMIN")
    @PostMapping
    public Creator create(@RequestBody Creator creator) {
        return creatorClient.create(creator);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping
    public Creator update(@RequestBody Creator creator) {
        return creatorClient.update(creator);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public Creator delete(@PathVariable Integer id) {
        return creatorClient.delete(id);
    }
}

