package com.mfvp.user.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfvp.user.models.UserModel;
import com.mfvp.user.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserModel save(UserModel user) {
        return repository.save(user);
    }
}
