package com.weapon.clients;

import com.weapon.dto.Creator;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "configurers-service", contextId = "creatorsClient", path = "/api/creators")
public interface CreatorClient {
    @RequestMapping(method = RequestMethod.GET)
    List<Creator> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Creator getById(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST)
    Creator create(@RequestBody Creator creator);

    @RequestMapping(method = RequestMethod.PUT)
    Creator update(@RequestBody Creator creator);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Creator delete(@PathVariable Integer id);
}
