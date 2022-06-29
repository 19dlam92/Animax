package com.lam.anime.controllers;
import java.util.List;

import com.lam.anime.models.AnimeModel;
import com.lam.anime.services.AnimeService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public AnimeAPI( AnimeService animeService ) {
        this.animeService = animeService;
    }


    // ====================================================
    // GET ALL . . . . 
    // ====================================================
    @RequestMapping( "/api/animes" )
    public List<AnimeModel> index() {
        return this.animeService.allAnimes();
    }


    // ====================================================
    // CREATE . . . . 
    // ====================================================
    @RequestMapping( value = "/api/animes", method = RequestMethod.POST )
    public AnimeModel create(
        @RequestParam( value = "shows" ) String shows,
        @RequestParam( value = "title" ) String title,
        @RequestParam( value = "genre" ) String genre,
        @RequestParam( value = "description" ) String description
        // Refer back to loaded constructor in the MODEL
        // for required fields or modification
        // don't forget to adjust table data and getters & setters
    ) {
        AnimeModel newAnime = new AnimeModel(shows, title, genre, description);
        return this.animeService.createAnime(newAnime);
        // CREATE INSTANCE OF A CLASS
    }


    // ====================================================
    // GET ON BY ID . . . . 
    // ====================================================
    @RequestMapping( "/api/anime/{id}" )
    public AnimeModel display( @PathVariable( "id" )Long id ) {
        // @PathVarible is used here because
        // we have an "id" used in the url
        AnimeModel animeDisplay = this.animeService.findAnime( id );
        return animeDisplay;
    }

}
