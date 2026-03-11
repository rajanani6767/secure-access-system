package com.cybersecurity.repository;

import com.cybersecurity.model.ThreatLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreatLogRepository extends JpaRepository<ThreatLog, Long> {
}