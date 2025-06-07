package com.projectplanner.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectplanner.dashboard.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
