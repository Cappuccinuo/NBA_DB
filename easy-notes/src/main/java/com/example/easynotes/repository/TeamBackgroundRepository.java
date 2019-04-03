package com.example.easynotes.repository;

import com.example.easynotes.model.TeamBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamBackgroundRepository extends JpaRepository<TeamBackground, String> {
}