package com.cybersecurity.ai;

import org.springframework.stereotype.Service;

@Service
public class ThreatDetectionService {

    public boolean detectThreat(int attempts) {

        if (attempts >= 3) {
            System.out.println("Brute force attack detected!");
            return true;
        }

        return false;
    }
}