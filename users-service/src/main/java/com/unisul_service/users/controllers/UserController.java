package com.unisul_service.users.controllers;

import com.unisul_service.users.entities.UserEntity;
import com.unisul_service.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<UserEntity> index(
            @RequestParam(required = false) String nameEnds,
            @RequestParam(required = false) String nameStarts
    ) {
        if (nameEnds !=  null && ! nameEnds.isEmpty()) {
            return service.findEndingWithName(nameEnds);
        }

        if (nameStarts != null && ! nameStarts.isEmpty()) {
            return service.findStartingWithName(nameStarts);
        }

        return service.getAll();
    }

    @PostMapping
    public UserEntity store(@RequestBody UserEntity userEntity) {
        return service.store(userEntity);
    }

    @PutMapping("/{id}")
    public UserEntity update(@PathVariable Integer id, @RequestBody UserEntity userEntity) {
        return service.update(userEntity, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
