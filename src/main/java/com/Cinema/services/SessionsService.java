package com.Cinema.services;

import com.Cinema.entyties.Session;
import com.Cinema.repositories.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sessionsService")
public class SessionsService {
    @Autowired
    SessionsRepository sessionsRepository;

    public void saveSession(Session session) {
        sessionsRepository.saveAndFlush(session);
    }

    public List<Session> findAllSessions() {
        return sessionsRepository.findAllSessions();
    }
}
