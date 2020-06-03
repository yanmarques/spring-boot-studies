package com.unisul_service.users.repositories;

import com.unisul_service.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public List<UserEntity> findByNameLike(String filter);
}
