package com.Cinema.controllers;

import com.Cinema.entyties.Message;
import com.Cinema.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private MessagesService messagesService;

    @MessageMapping("/{filmTitle}/chat")
    @SendTo(("/film/{filmTitle}/chat/messages"))
    public Message send(Message message)
    {
        Thread threadSave = new Thread(() -> messagesService.saveMessage(message));
        threadSave.start();
        return message;
    }

}
