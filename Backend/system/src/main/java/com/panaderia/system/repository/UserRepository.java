package com.panaderia.system.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.panaderia.system.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username); 
}
