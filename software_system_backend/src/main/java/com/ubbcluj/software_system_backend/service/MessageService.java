package com.ubbcluj.software_system_backend.service;

import com.ubbcluj.software_system_backend.jpa.entity.Message;
import com.ubbcluj.software_system_backend.jpa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message saveMessage(Message yourEntity) {
        return repository.save(yourEntity);
    }
}
