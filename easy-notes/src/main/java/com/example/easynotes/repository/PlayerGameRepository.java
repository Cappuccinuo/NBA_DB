package com.example.easynotes.repository;

import com.example.easynotes.identity.PlayerGameIdentity;
import com.example.easynotes.model.PlayerGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerGameRepository extends JpaRepository<PlayerGame, PlayerGameIdentity> {
}