package com.cybersecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.cybersecurity.model.ThreatLog;
import com.cybersecurity.repository.ThreatLogRepository;

@RestController
@RequestMapping("/threats")
public class ThreatController {

    @Autowired
    ThreatLogRepository repo;

    @GetMapping
    public List<ThreatLog> getThreats() {
        return repo.findAll();
    }
}