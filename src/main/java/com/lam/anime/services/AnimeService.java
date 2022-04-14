package com.lam.anime.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.lam.anime.models.AnimeModel;
import com.lam.anime.repositories.AnimeRepository;

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
    public List<AnimeModel> allAnimes() {
        // List<AnimeModel> = ModelClassName
        // allAnime initializes a function
        // animeRepository talks to our REPOSITORY
        return (List<AnimeModel>)this.animeRepository.findAll();
    }

    // ====================================================
	// METHOD that REPOSITORY to talk to the DATABASE
    // CREATES . . . . 
	// ====================================================
    public AnimeModel createAnime(AnimeModel anime) {
        // createAnime initializes a function
        return this.animeRepository.save(anime);
    }

    // ====================================================
	// METHOD that uses REPOSITORY to talk to DATABASE
    // FIND by ID . . . . 
	// ====================================================
    public AnimeModel findAnime(Long id) {
        // findAnime initializes a function
        // Long id here because
        // we're looking for ONE by ID
        // FINDS by id IF does not exist RETURN null
        return this.animeRepository.findById(id).orElse(null);
    }

    // ====================================================
	// METHOD that uses REPOSITORY to talk to DATABASE
    // UPDATE by ID . . . . 
	// ====================================================
    public AnimeModel updateAnime(AnimeModel anime) {
        // save(anime) - refers to 2nd variable in parameter
        // save(anime) here because
        // we're EDITING an existing ID
        return this.animeRepository.save(anime);
    }

    // ====================================================
	// METHOD that uses REPOSITORY to talk to DATABASE
    // DELETE by ID . . . . 
	// ====================================================
    public void deleteAnime(Long id) {
        // void INSTEAD of AnimeModel
        // void here because
        // 
        // Long id here because
        // we're looking for ONE by ID
        this.animeRepository.deleteById(id);
    }

}
