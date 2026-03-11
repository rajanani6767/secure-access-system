package com.cybersecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cybersecurity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}