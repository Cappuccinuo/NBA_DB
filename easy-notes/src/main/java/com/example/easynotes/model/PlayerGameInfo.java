package com.example.easynotes.model;

public class PlayerGameInfo {
    private GameInfo gameInfo;
    private Player player;
    private PlayerGame playerGame;

    public PlayerGameInfo() {
        super();
    }

    public PlayerGameInfo(GameInfo gameInfo, Player player, PlayerGame playerGame) {
        super();
        this.gameInfo = gameInfo;
        this.player = player;
        this.playerGame = playerGame;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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