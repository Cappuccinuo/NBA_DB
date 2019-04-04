package com.example.easynotes.repository;

import com.example.easynotes.identity.TeamSeasonIdentity;
import com.example.easynotes.model.TeamSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamSeasonRepository extends JpaRepository<TeamSeason, TeamSeasonIdentity> {
}