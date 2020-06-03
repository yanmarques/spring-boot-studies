package com.unisul_service.users.controllers;

import com.unisul_service.users.entities.CityEntity;
import com.unisul_service.users.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService service;

    @GetMapping
    public List<CityEntity> index() {
        return service.getAll();
    }

    @PostMapping
    public CityEntity store(@RequestBody CityEntity CityEntity) {
        return service.store(CityEntity);
    }

    @PutMapping("/{id}")
    public CityEntity update(@PathVariable Integer id, @RequestBody CityEntity CityEntity) {
        return service.update(CityEntity, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public HashMap<String, String> handleConstraintViolation() {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("error", "Oops, let me guess...this city belongs to some user, uuu so bad so bad");
        return errors;
    }
}