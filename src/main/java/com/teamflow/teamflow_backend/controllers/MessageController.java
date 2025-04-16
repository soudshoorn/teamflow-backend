package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.Message;
import com.teamflow.teamflow_backend.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @GetMapping("/channel/{channelId}")
    public List<Message> getMessagesByChannel(@PathVariable Long channelId) {
        return messageService.getAllMessagesByChannel(channelId);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody Message updatedMessage) {
        return messageService.updateMessage(id, updatedMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        if (messageService.deleteMessage(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}