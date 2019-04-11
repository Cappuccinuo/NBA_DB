package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


public class PlayerGameInfo {
    private GameInfo gameInfo;
    private PlayerGame playerGame;

    public PlayerGameInfo() {
        super();
    }

    public PlayerGameInfo(GameInfo gameInfo, PlayerGame playerGame) {
        super();
        this.gameInfo = gameInfo;
        this.playerGame = playerGame;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public PlayerGame getPlayerGame() {
        return playerGame;
    }

    public void setPlayerGame(PlayerGame playerGame) {
        this.playerGame = playerGame;
    }
}