package com.Cinema.services;

import com.Cinema.entyties.Film;
import com.Cinema.entyties.Message;
import com.Cinema.repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("messagesService")
public class MessagesService {

    @Autowired
    MessagesRepository messagesRepository;

    public List<Message> getMessagesByFilmId(Film film) {
        List<Message> messagesByFilmIdList = messagesRepository.findByFilm(film);
        Collections.reverse(messagesByFilmIdList);
        return messagesByFilmIdList;
    }

    public List<Message> getAllMessages() {
        return messagesRepository.findAll();
    }

    public void saveMessage(Message message) {
        messagesRepository.saveAndFlush(message);
    }

}
