package com.Cinema.services;

import com.Cinema.entyties.Film;
import com.Cinema.repositories.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("filmsService")
public class FilmsService {
    @Autowired
    FilmsRepository filmsRepository;

    public List<Film> findAllFilms() {
        return filmsRepository.findAll();
    }

    public void saveFilm(Film film) {
        filmsRepository.saveAndFlush(film);
    }

    public Film findFilmByName(String title) {
        return filmsRepository.findByTitle(title);
    }

    public Film findFilmById(int id) {
        return filmsRepository.getById(id);
    }
}
