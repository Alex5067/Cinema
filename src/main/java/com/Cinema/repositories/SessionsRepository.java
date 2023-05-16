package com.Cinema.repositories;

import com.Cinema.entyties.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionsRepository extends JpaRepository<Session, Integer> {
    @Query("SELECT s FROM Session s JOIN FETCH s.film")
    List<Session> findAllSessions();
}
