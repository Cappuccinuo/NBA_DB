package com.example.easynotes.repository;

import com.example.easynotes.identity.PlayerSeasonIdentity;
import com.example.easynotes.model.PlayerSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerSeasonRepository extends JpaRepository<PlayerSeason, PlayerSeasonIdentity> {
    @Query(value =
            "SELECT * FROM player_season p WHERE p.player_id = :player_id AND p.season = :season", nativeQuery = true)
    List<PlayerSeason> getPlayerBySeason(@Param("player_id") String player_id, @Param("season") String season);
}