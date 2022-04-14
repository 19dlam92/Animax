package com.lam.anime.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lam.anime.models.AnimeModel;
import com.lam.anime.services.AnimeService;

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
    @RequestMapping("/api/animes")
    public List<AnimeModel> index() {
        return this.animeService.allAnimes();
    }

    @RequestMapping(value = "/api/animes", method = RequestMethod.POST)
    public AnimeModel create(
        @RequestParam(value = "shows") String shows,
        @RequestParam(value = "manga") String manga,
        @RequestParam(value = "genre") String genre
        // Refer back to loaded constructor in the MODEL for required fields
    ) {

        // ====================================================
        // CREATE INSTANCE OF A CLASS
        // ====================================================
        AnimeModel newAnime = new AnimeModel(shows, manga, genre);
        return this.animeService.createAnime(newAnime);
    
    }

    // ====================================================
    // GET ON BY ID . . . . 
    // ====================================================
    @RequestMapping("/api/anime/{id}")
    public AnimeModel display(@PathVariable("id")Long id) {
        // @PathVarible is used here because
        // we have an "id" used in the url
        AnimeModel animeDisplay = this.animeService.findAnime(id);
        return animeDisplay;
    }

}

// We're only collecting data from the API
// So we only need GET METHODS
