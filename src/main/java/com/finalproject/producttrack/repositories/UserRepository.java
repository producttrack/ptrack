package com.finalproject.producttrack.repositories;

import com.finalproject.producttrack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);
    User findOneByLogin(String login);
}
