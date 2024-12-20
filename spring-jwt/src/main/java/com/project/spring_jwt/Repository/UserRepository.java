package com.project.spring_jwt.Repository;

import com.project.spring_jwt.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);
    Optional<User> findByEmail(String email);
}
