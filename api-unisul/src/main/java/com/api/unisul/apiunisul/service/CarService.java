package com.api.unisul.apiunisul.service;

import com.api.unisul.apiunisul.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarById(int id) {
        for (Car car: getCars()) {
            if (car.getId() == id) {
                return car;
            }
        }

        return null;
    }
}
