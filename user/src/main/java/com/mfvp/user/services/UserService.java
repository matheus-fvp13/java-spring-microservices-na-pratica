package com.mfvp.user.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfvp.user.models.UserModel;
import com.mfvp.user.produces.UserProducer;
import com.mfvp.user.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserProducer producer;

    public UserService(UserRepository repository, UserProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Transactional
    public UserModel save(UserModel user) {
        var userModel = repository.save(user);
        producer.publishMessageEmail(userModel);
        return userModel;
    }
}
