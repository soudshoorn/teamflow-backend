package com.teamflow.teamflow_backend.repositories;

import com.teamflow.teamflow_backend.models.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepository extends JpaRepository<Epic, Long> {
    // eventueel custom queries
}