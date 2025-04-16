package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.UserStory;
import com.teamflow.teamflow_backend.services.UserStoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userstories")
@CrossOrigin
public class UserStoryController {

    private final UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping
    public List<UserStory> getAllUserStories() {
        return userStoryService.getAllUserStories();
    }

    @GetMapping("/{id}")
    public UserStory getUserStoryById(@PathVariable Long id) {
        return userStoryService.getUserStoryById(id);
    }

    @PostMapping
    public UserStory createUserStory(@RequestBody UserStory userStory) {
        return userStoryService.createUserStory(userStory);
    }

    @PutMapping("/{id}")
    public UserStory updateUserStory(@PathVariable Long id, @RequestBody UserStory updatedStory) {
        return userStoryService.updateUserStory(id, updatedStory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserStory(@PathVariable Long id) {
        if (userStoryService.deleteUserStory(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}