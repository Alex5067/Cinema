package com.Cinema.repositories;

import com.Cinema.entyties.Film;
import com.Cinema.entyties.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Message, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT m.* " +
                    "FROM message m " +
                    "INNER JOIN users_cinema u " +
                    "ON (u.id = m.cookie_id) " +
                    "WHERE m.film_id = :film " +
                    "ORDER BY m.id DESC LIMIT 20")
    List<Message> findByFilm(@Param("film") Film film);
}
