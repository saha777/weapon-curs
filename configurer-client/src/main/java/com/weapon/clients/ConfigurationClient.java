package com.weapon.clients;

import com.weapon.dto.Configuration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "configurers-service", contextId = "configurationsClient", path = "/api/configurations")
public interface ConfigurationClient {
    @RequestMapping(method = RequestMethod.GET)
    List<Configuration> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Configuration getById(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST)
    Configuration create(@RequestBody Configuration configuration);

    @RequestMapping(method = RequestMethod.PUT)
    Configuration update(@RequestBody Configuration configuration);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Configuration delete(@PathVariable Integer id);
}
