package com.teamflow.teamflow_backend.repositories;

import com.teamflow.teamflow_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // eventueel extra methodes, bijv. findByUsername
}