package com.weapon.clients;

import com.weapon.dto.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "configurers-service", contextId = "carsClient", path = "/api/cars")
public interface CarClient {
    @RequestMapping(method = RequestMethod.GET)
    List<Car> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Car getById(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.GET, value = "/configurations/{configurationId}")
    List<Car> getByConfigurationId(@PathVariable Integer configurationId);

    @RequestMapping(method = RequestMethod.GET, value = "/creators/{creatorId}")
    List<Car> getByCreatorId(@PathVariable Integer creatorId);

    @RequestMapping(method = RequestMethod.POST)
    Car create(@RequestBody Car car);

    @RequestMapping(method = RequestMethod.PUT)
    Car update(@RequestBody Car car);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Car delete(@PathVariable Integer id);
}
