package com.teamflow.teamflow_backend.services;

import com.teamflow.teamflow_backend.models.Epic;
import com.teamflow.teamflow_backend.repositories.EpicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpicService {

    private final EpicRepository epicRepository;

    public EpicService(EpicRepository epicRepository) {
        this.epicRepository = epicRepository;
    }

    public List<Epic> getAllEpics() {
        return epicRepository.findAll();
    }

    public Epic getEpicById(Long id) {
        return epicRepository.findById(id).orElse(null);
    }

    public Epic createEpic(Epic epic) {
        return epicRepository.save(epic);
    }

    public Epic updateEpic(Long id, Epic updatedEpic) {
        return epicRepository.findById(id)
                .map(existingEpic -> {
                    existingEpic.setTitle(updatedEpic.getTitle());
                    existingEpic.setDescription(updatedEpic.getDescription());
                    return epicRepository.save(existingEpic);
                })
                .orElse(null);
    }

    public boolean deleteEpic(Long id) {
        if (epicRepository.existsById(id)) {
            epicRepository.deleteById(id);
            return true;
        }
        return false;
    }
}