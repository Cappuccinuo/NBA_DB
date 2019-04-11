package com.example.easynotes.repository;

import com.example.easynotes.model.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeam, String> {
}