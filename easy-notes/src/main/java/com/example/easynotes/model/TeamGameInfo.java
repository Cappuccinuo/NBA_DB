package com.example.easynotes.model;

public class TeamGameInfo {
    private GameInfo gameInfo;
    private TeamGame teamGame;

    public TeamGameInfo() {
        super();
    }

    public TeamGameInfo(GameInfo gameInfo, TeamGame teamGame) {
        super();
        this.gameInfo = gameInfo;
        this.teamGame = teamGame;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public TeamGame getTeamGame() {
        return teamGame;
    }

    public void setTeamGame(TeamGame teamGame) {
        this.teamGame = teamGame;
    }
}