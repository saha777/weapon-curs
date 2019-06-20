package com.weapon.clients;

import com.weapon.dto.Weapon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "configurers-service", contextId = "weaponsClient", path = "/api/weapons")
public interface WeaponClient {
    @RequestMapping(method = RequestMethod.GET)
    List<Weapon> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Weapon getById(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST)
    Weapon create(@RequestBody Weapon weapon);

    @RequestMapping(method = RequestMethod.PUT)
    Weapon update(@RequestBody Weapon weapon);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Weapon delete(@PathVariable Integer id);
}
