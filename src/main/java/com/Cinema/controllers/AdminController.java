package com.Cinema.controllers;

import com.Cinema.entyties.Film;
import com.Cinema.entyties.Hall;
import com.Cinema.services.FilmsService;
import com.Cinema.services.HallsService;
import com.Cinema.services.SessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AdminController {

    @Autowired
    private HallsService hallsService;

    @Autowired
    private FilmsService filmsService;

    @Autowired
    private SessionsService sessionsService;

    @GetMapping( "/admin/panel")
    public String index() {
        return "admin-panel";
    }

    @GetMapping("/admin/panel/halls")
    public String addHallsForm(Model model)
    {
        model.addAttribute("hall", new Hall());
        return "add-halls";
    }

    @PostMapping("/admin/panel/halls")
    public String addHallsSave(@ModelAttribute("hall") Hall hall)
    {
        hallsService.saveHall(hall);
        return "redirect:/admin/panel";
    }

    @GetMapping("/admin/panel/films")
    public String addFilmsForm(Model model)
    {
        model.addAttribute("film", new Film());
        return "add-films";
    }

    @PostMapping("/admin/panel/films")
    public String addFilmsSave(@RequestParam MultipartFile file, @ModelAttribute("film") Film film) throws Exception
    {
        String path = "./src/main/resources/posters";
        String uniqueName = ImageController.saveImage(path, file, file.getContentType());
        assert uniqueName != null;

        filmsService.saveFilm(new Film(film.getTitle(), film.getYear(), film.getDescription(), uniqueName));
        return "redirect:/admin/panel";
    }

    @GetMapping("/admin/panel/sessions")
    public String addSessions(Model model)
    {
        model.addAttribute("halls", hallsService.findAllHalls());
        model.addAttribute("films", filmsService.findAllFilms());
        return "add-sessions";
    }

    @PostMapping("/admin/panel/sessions")
    public String submit(@ModelAttribute("selectedHall") String selectedHall, @ModelAttribute("selectedFilm") String selectedFilm,
                         @ModelAttribute("selectedDate") String selectedDate, @ModelAttribute("selectedPrice") String selectedPrice)
    {
    }
}
