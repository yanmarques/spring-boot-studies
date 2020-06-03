package com.mysqldb.test.services;

import com.mysqldb.test.domains.City;
import com.mysqldb.test.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository repo;

    public List<City> findAll() {
        return repo.findAll();
    }

    public City store(City c) {
        return repo.save(c);
    }
}
