package com.mysqldb.test.controllers;

import com.mysqldb.test.domains.City;
import com.mysqldb.test.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService service;

    @GetMapping
    public List<City> index() {
        return service.findAll();
    }

    @PostMapping
    public City store(@RequestBody City c) {
        return service.store(c);
    }
}
