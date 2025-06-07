package com.projectplanner.dashboard.repositories;

import com.projectplanner.dashboard.models.User;
import com.projectplanner.dashboard.util.EncryptedFileStorage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserFileRepository {
    private static final String FILE_PATH = "users.enc";
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Optional<User> findByUsername(String username) throws Exception {
        List<String> lines = EncryptedFileStorage.load(FILE_PATH);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[0].equals(username)) {
                User user = new User();
                user.setUsername(parts[0]);
                user.setPassword(parts[1]);
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean existsByUsername(String username) throws Exception {
        List<String> lines = EncryptedFileStorage.load(FILE_PATH);
        for (String line : lines) {
            if (line.split(",")[0].equals(username)) return true;
        }
        return false;
    }

    public void save(User user) throws Exception {
        List<String> lines = EncryptedFileStorage.load(FILE_PATH);
        lines.add(user.getUsername() + "," + user.getPassword());
        EncryptedFileStorage.save(lines, FILE_PATH);
    }
}
