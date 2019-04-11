package com.example.easynotes.model;

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