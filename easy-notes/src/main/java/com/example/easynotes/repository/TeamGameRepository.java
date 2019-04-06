package com.example.easynotes.repository;

import com.example.easynotes.identity.TeamGameIdentity;
import com.example.easynotes.model.TeamGame;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamGameRepository extends JpaRepository<TeamGame, TeamGameIdentity> {
    @Query(value = "SELECT * FROM team_game t WHERE t.team_id = :team_id", nativeQuery = true)
    List<TeamGame> getAllTeamGame(@Param("team_id") String team_id);

    @Query(value = "SELECT * FROM team_game t WHERE t.team_id = :team_id ORDER BY STR_TO_DATE(t.game_date, \"%b %d, %Y\") DESC", nativeQuery = true)
    List<TeamGame> getNumTeamGame(@Param("team_id") String team_id, Pageable pageSize);
}