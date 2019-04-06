package com.example.easynotes.repository;

import com.example.easynotes.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    @Query(value =
            "SELECT * FROM player p WHERE p.team_id = :team_id", nativeQuery = true)
    List<Player> getAllTeamPlayer(@Param("team_id") String team_id);
}