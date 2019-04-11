package com.example.easynotes.repository;

import com.example.easynotes.model.TeamBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamBackgroundRepository extends JpaRepository<TeamBackground, String> {
    @Query(value =
            "CALL get_team_of_player(:player_id)", nativeQuery = true)
    TeamBackground getTeamOfPlayer(@Param("player_id") String player_id);
}