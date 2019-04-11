package com.example.easynotes.model;

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
