package com.unisul_service.users.services;

import com.unisul_service.users.entities.CityEntity;
import com.unisul_service.users.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    public List<CityEntity> getAll() {
        return repository.findAll();
    }

    public CityEntity store(CityEntity CityEntity) {
        return repository.save(CityEntity);
    }

    public CityEntity update(CityEntity CityEntity, Integer id) {
//        Assert.notNull(id, "ID must not be null, asshole!");
        Optional<CityEntity> optEntity = repository.findById(id);

        if (optEntity.isEmpty()) {
            return null;
        }

        return repository.save(optEntity.get().fromEntity(CityEntity));
    }

    public void delete(Integer id) {
//        Assert.notNull(id, "ID must not be null, asshole!");

        Optional<CityEntity> optEntity = repository.findById(id);
        optEntity.ifPresent(CityEntity -> repository.delete(CityEntity));
    }
}
