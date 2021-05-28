package com.example.geriafarm.controllers;

import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveSubstController {

    private final ActiveSubstService activeSubstService;

    public ActiveSubstController(ActiveSubstService activeSubstService) {
        this.activeSubstService = activeSubstService;
    }
}
