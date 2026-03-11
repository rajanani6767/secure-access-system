package com.cybersecurity.service;
import com.cybersecurity.ai.ThreatDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybersecurity.model.User;
import com.cybersecurity.repository.UserRepository;
import com.cybersecurity.ai.ThreatDetectionService;

@Service
public class AuthService {

    @Autowired
    UserRepository repo;

    @Autowired
    ThreatDetectionService ai;

    public String login(String username, String password, String ip){

        User user = repo.findByUsername(username);

        if (user == null) {
            return "User not found";
        }

        if (user.isLocked()) {
            return "Account Locked";
        }

        if (user.getPassword().equals(password)) {

            user.setFailedAttempts(0);
            repo.save(user);

            return "Login Success";
        }

        int attempts = user.getFailedAttempts() + 1;
        user.setFailedAttempts(attempts);

        if (ai.detectThreat(attempts)) {
            user.setLocked(true);
        }

        repo.save(user);

        return "Invalid Password";
    }
}