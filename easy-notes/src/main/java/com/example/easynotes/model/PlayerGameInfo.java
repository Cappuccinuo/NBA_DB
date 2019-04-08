package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


public class PlayerGameInfo {
    private String date;
    private String matchup;
    private PlayerGame playerGame;

    public PlayerGameInfo() {
        super();
    }

    public PlayerGameInfo(String date, String matchup, PlayerGame playerGame) {
        super();
        this.date = date;
        this.matchup = matchup;
        this.playerGame = playerGame;
    }

    public String getMatchup() {
        return matchup;
    }

    public void setMatchup(String matchup) {
        this.matchup = matchup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PlayerGame getPlayerGame() {
        return playerGame;
    }

    public void setPlayerGame(PlayerGame playerGame) {
        this.playerGame = playerGame;
    }
}