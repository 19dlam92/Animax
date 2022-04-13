package com.lam.anime.services;

import com.lam.anime.repositories.AnimeRepository;

import org.springframework.stereotype.Service;

@Service
public class AnimeService {

    // ==============================================
	// This is a non-changing variable
    // AnimeRepository = Name of Method
    // animeRepository = TALK to the REPOSITORY
    // ==============================================
    private final AnimeRepository animeRepository;

    // ====================================================
	// CONSTRUCTOR that INJECTS repository - DEPENDENCY INJECTION
    // Intializes the SERVICE with connection to the REPOSITORY
	// ====================================================
    public AnimeService(AnimeRepository animeRepository) {
        // 2nd variable of the parameter goes here
        this.animeRepository = animeRepository;
    }

    // ====================================================
	// METHOD that uses REPOSITORY to talk to the DATABASE
    // RETURNS all the . . . . 
	// ====================================================




    // ====================================================
	// METHOD that REPOSITORY to talk to the DATABASE
    // CREATES . . . . 
	// ====================================================




    // ====================================================
	// METHOD that uses REPOSITORY to talk to DATABASE
    // FIND by ID . . . . 
	// ====================================================




    // ====================================================
	// METHOD that uses REPOSITORY to talk to DATABASE
    // UPDATE by ID . . . . 
	// ====================================================




    // ====================================================
	// METHOD that uses REPOSITORY to talk to DATABASE
    // DELETE by ID . . . . 
	// ====================================================

}
