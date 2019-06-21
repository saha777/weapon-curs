package com.weapon.controllers;

import com.weapon.entities.Configuration;
import com.weapon.repositories.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configurations")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationRepository configurationRepository;

    @GetMapping
    public List<Configuration> getAll() {
        return configurationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Configuration getById(@PathVariable Integer id) {
        return findById(id);
    }

    @PostMapping
    public Configuration create(@RequestBody Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    @PutMapping
    public Configuration update(@RequestBody Configuration configuration) {
        findById(configuration.getId());
        return configurationRepository.save(configuration);
    }

    @DeleteMapping("/{id}")
    public Configuration delete(@PathVariable Integer id) {
        Configuration configuration = findById(id);
        configurationRepository.delete(configuration);
        return configuration;
    }

    private Configuration findById(Integer id) {
        return configurationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found entity by id"));
    }
}
