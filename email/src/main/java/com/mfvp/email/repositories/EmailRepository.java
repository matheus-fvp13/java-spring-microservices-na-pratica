package com.mfvp.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfvp.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}
