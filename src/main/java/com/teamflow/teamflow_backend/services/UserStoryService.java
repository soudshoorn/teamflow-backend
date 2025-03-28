package com.teamflow.teamflow_backend.services;

import com.teamflow.teamflow_backend.models.UserStory;
import com.teamflow.teamflow_backend.repositories.UserStoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;

    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public List<UserStory> getAllUserStories() {
        return userStoryRepository.findAll();
    }

    public UserStory getUserStoryById(Long id) {
        return userStoryRepository.findById(id).orElse(null);
    }

    public UserStory createUserStory(UserStory userStory) {
        return userStoryRepository.save(userStory);
    }

    public UserStory updateUserStory(Long id, UserStory updated) {
        return userStoryRepository.findById(id)
                .map(story -> {
                    story.setTitle(updated.getTitle());
                    story.setDescription(updated.getDescription());
                    story.setEpic(updated.getEpic());
                    return userStoryRepository.save(story);
                })
                .orElse(null);
    }

    public boolean deleteUserStory(Long id) {
        if (userStoryRepository.existsById(id)) {
            userStoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}