package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.Epic;
import com.teamflow.teamflow_backend.services.EpicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epics")
@CrossOrigin
public class EpicController {

    private final EpicService epicService;

    public EpicController(EpicService epicService) {
        this.epicService = epicService;
    }

    @GetMapping
    public List<Epic> getAllEpics() {
        return epicService.getAllEpics();
    }

    @GetMapping("/{id}")
    public Epic getEpicById(@PathVariable Long id) {
        return epicService.getEpicById(id);
    }

    @PostMapping
    public Epic createEpic(@RequestBody Epic epic) {
        return epicService.createEpic(epic);
    }

    @PutMapping("/{id}")
    public Epic updateEpic(@PathVariable Long id, @RequestBody Epic updatedEpic) {
        return epicService.updateEpic(id, updatedEpic);
    }

    @DeleteMapping("/{id}")
    public void deleteEpic(@PathVariable Long id) {
        epicService.deleteEpic(id);
    }
}