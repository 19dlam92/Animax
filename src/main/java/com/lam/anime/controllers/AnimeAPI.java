package com.lam.anime.controllers;
import com.lam.anime.services.AnimeService;

import org.springframework.web.bind.annotation.RestController;

// ====================================================
// TALKS TO THE SERVICE
// ====================================================
@RestController
public class AnimeAPI {
    
    // ====================================================
    // INITAILIZES API TO TALK TO THE SERVICE
    // ====================================================
    private final AnimeService animeService;

    // ====================================================
    // CONSTRUCTOR
    // ====================================================
    public AnimeAPI(AnimeService animeService) {
        this.animeService = animeService;
    }

    // ====================================================
    // GET/DISPLAY ALL . . . . 
    // ====================================================



    // ====================================================
    // GET ON BY ID . . . . 
    // ====================================================


}

// We're only collecting data from the API
// So we only need GET METHODS
