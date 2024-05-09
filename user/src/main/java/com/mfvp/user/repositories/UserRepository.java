package com.mfvp.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfvp.user.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    
}
