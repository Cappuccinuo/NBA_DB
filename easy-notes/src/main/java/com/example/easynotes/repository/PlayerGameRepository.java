package com.example.easynotes.repository;

import com.example.easynotes.identity.PlayerGameIdentity;
import com.example.easynotes.model.PlayerGame;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerGameRepository extends JpaRepository<PlayerGame, PlayerGameIdentity> {
    @Query(value = "SELECT p.* FROM ((SELECT * FROM player_game WHERE player_id = :player_id) p JOIN team_game t ON p.game_id = t.game_id AND p.team_id = t.team_id) ORDER BY STR_TO_DATE(t.game_date, \"%b %d, %Y\") DESC", nativeQuery = true)
    List<PlayerGame> getNumTeamGame(@Param("player_id") String player_id, Pageable pageSize);
}