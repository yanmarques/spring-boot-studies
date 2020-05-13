package com.api.unisul.apiunisul.controller;

import com.api.unisul.apiunisul.domain.Car;
import com.api.unisul.apiunisul.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService service;

    @GetMapping
    public List<Car> index() {
        return service.getCars();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public Car show(@PathVariable(name = "id") int id) {
        Car car = service.getCarById(id);
        if (car == null) {
            throw new NotFoundException("Car not found.");
        }
        return car;
    }

    @PostMapping
    public void show(@RequestBody Car car) {
        service.getCars().add(car);
    }

    @PutMapping("{id}")
    public Car update(@PathVariable(name = "id") int id, @RequestBody Map<String, Object> data) {
        Car foundCar = service.getCarById(id);

        if (foundCar == null) {
            throw new NotFoundException("Car not found");
        }

        if (data.get("name") != null) {
            foundCar.setName((String) data.get("name"));
        }

        if (data.get("year") != null) {
            foundCar.setYear((String) data.get("year"));
        }

        return foundCar;
    }
}
