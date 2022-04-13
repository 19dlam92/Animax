package com.lam.anime.controllers;

import com.lam.anime.services.AnimeService;

import org.springframework.stereotype.Controller;

@Controller
public class AnimeController {

    // ==============================================
	// INITIALIZES CONTROLLER TO TALK TO THE SERVICE
	// ==============================================
    private final AnimeService animeService;

    // ==============================================
    // CONSTRUCTOR that INJECTS service - DEPENDENCY INJECTION
    // ==============================================
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    // ==============================================
    // SHOW ALL
    // ==============================================



    // ==============================================
    // SHOW ONE
    // ==============================================



    // ==============================================
    // CREATE
    // ==============================================



    // ==============================================
    // UPDATE
    // ==============================================



    // ==============================================
    // DELETE
    // ==============================================



}
