package com.example.easynotes.repository;

import com.example.easynotes.identity.PlayerSeasonIdentity;
import com.example.easynotes.model.PlayerSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSeasonRepository extends JpaRepository<PlayerSeason, PlayerSeasonIdentity> {
}