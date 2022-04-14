package com.lam.anime.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lam.anime.models.AnimeModel;
import com.lam.anime.services.AnimeService;

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
    @RequestMapping("/anime")
    public String index(Model model) {
        List<AnimeModel> allAnimes = this.animeService.allAnimes();
        // List<ModelClassName>
        model.addAttribute("allAnimes", allAnimes);
        model.addAttribute("newAnime", new AnimeModel());
        // ^ This CREATES one ^
        // new AnimeModel() = empty anime object
        // HTML catches the variable ". . . ."
        return "AllAnime.jsx";
    }

    // ==============================================
    // SHOW ONE
    // ==============================================
    @RequestMapping("/anime/{id}")
    public String displayOne(Long id, Model model) {
        AnimeModel displayOneAnime = this.animeService.findAnime(id);
        model.addAttribute("oneAnime", displayOneAnime);
        return "AnimeDetails.jsx";
    }

    // ==============================================
    // CREATE
    // ==============================================
    @RequestMapping(value = "/anime/add", method = RequestMethod.POST)
    public String create(
            @Valid @ModelAttribute("newAnime")
            AnimeModel anime,
            BindingResult result,
            Model model
            // @Valid = pulls the validation errors
            // @Valid @ModelAttribute ALWAYS go together
            // BindingResults = stores any errors
            ) {
        if (result.hasErrors()) {
            List<AnimeModel> allAnimes = this.animeService.allAnimes();
            model.addAttribute("allAnimes", allAnimes);
            // List<ModelClassName> needs to be here because
            // the render will display errors with information
            return "AllAnime.jsx";
        } else {
            this.animeService.createAnime(anime);
            return "redirect:/anime";
        }
    }

    // ==============================================
    // UPDATE
    // ==============================================
    @RequestMapping("/anime/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        AnimeModel editAnime = this.animeService.findAnime(id);
        model.addAttribute("editAnime", editAnime);
        return "/anime/AnimeEdit.jsx";
    }

    @RequestMapping(value = "/anime/update/{id}", method = RequestMethod.PUT)
    public String update(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("editAnime")
            AnimeModel anime,
            BindingResult result
            ) {
        if (result.hasErrors()) {
            return "AnimeEdit.jsx";
        } else {
            this.animeService.updateAnime(anime);
            return "redirect:/anime";
        }
    }

    // ==============================================
    // DELETE
    // ==============================================
    @RequestMapping(value = "/anime/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.animeService.deleteAnime(id);
        return "redirect:/anime";
    }

}

// instead of returning/redirecting to files.jsp its files.jsx?
// how do we redirect in java if react doesnt redirect?
