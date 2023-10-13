package com.example.MessagingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody Message message) {
        messageRepository.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Message>> receiveMessages() {
        List<Message> receivedMessages = messageRepository.receiveMessages();
        return ResponseEntity.ok(receivedMessages);
    }
}

