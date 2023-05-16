package com.Cinema.repositories;

import com.Cinema.entyties.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmsRepository extends JpaRepository<Film, Integer> {

    @Query("SELECT f FROM Film f WHERE lower(f.title) = :title")
    Film findByTitle(@Param("title") String title);
}
