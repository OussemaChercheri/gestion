package com.tekup.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gestion.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
