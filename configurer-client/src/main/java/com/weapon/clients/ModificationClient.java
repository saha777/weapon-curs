package com.weapon.clients;

import com.weapon.dto.Modification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "configurers-service", contextId = "modificationsClient", path = "/api/modifications")
public interface ModificationClient {
    @RequestMapping(method = RequestMethod.GET)
    List<Modification> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Modification getById(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST)
    Modification create(@RequestBody Modification modification);

    @RequestMapping(method = RequestMethod.PUT)
    Modification update(@RequestBody Modification modification);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Modification delete(@PathVariable Integer id);
}
