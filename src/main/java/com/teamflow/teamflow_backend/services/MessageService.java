package com.teamflow.teamflow_backend.services;

import com.teamflow.teamflow_backend.models.Message;
import com.teamflow.teamflow_backend.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getAllMessagesByChannel(Long channelId) {
        return messageRepository.findByChannelId(channelId);
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message createMessage(Message message) {
        // Timestamp instellen, etc.
        message.setTimestamp(System.currentTimeMillis());
        return messageRepository.save(message);
    }

    public Message updateMessage(Long id, Message updatedMessage) {
        return messageRepository.findById(id)
                .map(existingMessage -> {
                    existingMessage.setContent(updatedMessage.getContent());
                    existingMessage.setEpic(updatedMessage.getEpic());
                    existingMessage.setUserStory(updatedMessage.getUserStory());
                    existingMessage.setTask(updatedMessage.getTask());
                    return messageRepository.save(existingMessage);
                })
                .orElse(null);
    }

    public boolean deleteMessage(Long id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }

}