package com.mysqldb.test.repositories;

import com.mysqldb.test.domains.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
