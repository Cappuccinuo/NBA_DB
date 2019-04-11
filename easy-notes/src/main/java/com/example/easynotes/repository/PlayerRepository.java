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
            "CALL get_players_of_team(:team_id)", nativeQuery = true)
    List<Player> getAllTeamPlayer(@Param("team_id") String team_id);

    //https://stackoverflow.com/questions/25362540/like-query-in-spring-jparepository
    @Query(value =
            "SELECT * FROM player p WHERE p.name LIKE :name%", nativeQuery = true)
    List<Player> getPlayerGivenName(@Param("name") String name);
}