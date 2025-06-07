package com.projectplanner.services;

import com.projectplanner.dashboard.models.User;
import com.projectplanner.dashboard.repositories.UserFileRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserFileRepository userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserFileRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean register(String username, String password) throws Exception {
        if (userRepo.existsByUsername(username)) return false;
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        userRepo.save(user);
        return true;
    }

    public boolean login(String username, String password) throws Exception {
        var userOpt = userRepo.findByUsername(username);
        return userOpt.isPresent() && encoder.matches(password, userOpt.get().getPassword());
    }
}
