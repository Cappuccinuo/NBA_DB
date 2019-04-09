package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


public class PlayerSeasonInfo {
    private String team_abbreviation;
    private PlayerSeason playerSeason;

    public PlayerSeasonInfo() {
        super();
    }

    public PlayerSeasonInfo(String team_abbreviation, PlayerSeason playerSeason) {
        super();
        this.team_abbreviation = team_abbreviation;
        this.playerSeason = playerSeason;
    }

    public PlayerSeason getPlayerSeason() {
        return playerSeason;
    }

    public String getTeam_abbreviation() {
        return team_abbreviation;
    }

    public void setPlayerSeason(PlayerSeason playerSeason) {
        this.playerSeason = playerSeason;
    }

    public void setTeam_abbreviation(String team_abbreviation) {
        this.team_abbreviation = team_abbreviation;
    }
}
