package com.example.easynotes.repository;

import com.example.easynotes.identity.PlayerGameIdentity;
import com.example.easynotes.model.PlayerGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerGameRepository extends JpaRepository<PlayerGame, PlayerGameIdentity> {
    @Query(value = "CALL get_player_game_desc(:player_id, :page_num)", nativeQuery = true)
    List<PlayerGame> getNumPlayerGame(@Param("player_id") String player_id, @Param("page_num") int page_num);

    @Query(value = "CALL get_player_games_given_team_and_game(:team_id, :game_id)", nativeQuery = true)
    List<PlayerGame> getGamesGivenTeamAndGame(@Param("team_id") String team_id, @Param("game_id") String game_id);
}