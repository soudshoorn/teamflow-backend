package com.teamflow.teamflow_backend.repositories;

import com.teamflow.teamflow_backend.models.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
}