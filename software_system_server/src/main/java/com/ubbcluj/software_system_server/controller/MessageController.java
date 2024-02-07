package com.ubbcluj.software_system_server.controller;

import com.ubbcluj.software_system_server.domain.MessageResponse;
import com.ubbcluj.software_system_server.jpa.entity.Message;
import com.ubbcluj.software_system_server.service.MessageService;
import com.ubbcluj.software_system_server.service.MqttPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @Autowired
    private MqttPublisherService mqttPublisherService;

    @GetMapping("/data")
    public ResponseEntity<List<Message>> sendAllData() {
        System.out.println("Successfully received!");
        List<Message> messageList = messageService.findAllMessages();
        return ResponseEntity.ok(messageList);
    }

    @GetMapping("/send")
    public ResponseEntity<MessageResponse> sendMqtt() {
        System.out.println("Successfully received!");
        mqttPublisherService.publishMessage("{\"message\": \"Hello from the server.\"}");
        String message = "Successfully received!";
        MessageResponse response = new MessageResponse(message);
        return ResponseEntity.ok(response);
    }
}
