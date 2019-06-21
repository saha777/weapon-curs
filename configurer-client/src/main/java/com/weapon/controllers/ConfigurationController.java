package com.weapon.controllers;

import com.weapon.clients.ConfigurationClient;
import com.weapon.dto.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/configurations")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationClient configurationClient;

    @GetMapping
    public List<Configuration> getAll() {
        return configurationClient.getAll();
    }

    @GetMapping("/{id}")
    public Configuration getById(@PathVariable Integer id) {
        return configurationClient.getById(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public Configuration create(@RequestBody Configuration configuration) {
        return configurationClient.create(configuration);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping
    public Configuration update(@RequestBody Configuration configuration) {
        return configurationClient.update(configuration);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public Configuration delete(@PathVariable Integer id) {
        return configurationClient.delete(id);
    }
}
