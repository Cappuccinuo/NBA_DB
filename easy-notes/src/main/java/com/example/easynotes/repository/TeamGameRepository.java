package com.example.easynotes.repository;

import com.example.easynotes.identity.TeamGameIdentity;
import com.example.easynotes.model.TeamGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamGameRepository extends JpaRepository<TeamGame, TeamGameIdentity> {
}