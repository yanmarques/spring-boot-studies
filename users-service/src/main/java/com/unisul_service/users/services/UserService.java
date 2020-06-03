package com.unisul_service.users.services;

import com.unisul_service.users.entities.UserEntity;
import com.unisul_service.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    public List<UserEntity> findStartingWithName(String fragment) {
        return handleFindByNameLike(fragment, s -> s.concat("%"));
    }

    public List<UserEntity> findEndingWithName(String fragment) {
        return handleFindByNameLike(fragment, "%"::concat);
    }

    public UserEntity store(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    public UserEntity update(UserEntity userEntity, Integer id) {
//        Assert.notNull(id, "ID must not be null, asshole!");
        Optional<UserEntity> optEntity = repository.findById(id);

        if (optEntity.isEmpty()) {
            return null;
        }

        return repository.save(optEntity.get().fromEntity(userEntity));
    }

    public void delete(Integer id) {
//        Assert.notNull(id, "ID must not be null, asshole!");

        Optional<UserEntity> optEntity = repository.findById(id);
        optEntity.ifPresent(userEntity -> repository.delete(userEntity));
    }

    protected List<UserEntity> handleFindByNameLike(
            String filter,
            Function<String, String> onFilter
    ) {
        // TODO use spring builtin Starting and Ending functions
        String parsedFilter = onFilter.apply(filter.replace("%", "\\%"));
        return repository.findByNameLike(parsedFilter);
    }
}
