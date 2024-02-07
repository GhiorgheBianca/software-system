package com.ubbcluj.software_system_server.service;

import com.ubbcluj.software_system_server.jpa.entity.Message;
import com.ubbcluj.software_system_server.jpa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> findAllMessages() {
        return repository.findAll();
    }
}
