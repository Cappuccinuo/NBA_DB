package com.example.easynotes.model;

import com.example.easynotes.identity.PlayerGameIdentity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "game_info")
@EntityListeners(AuditingEntityListener.class)

public class GameInfoTable {
    @Id
    private String game_id;
    private String game_date;
    private String season;
    private String away_team_id;
    private String home_team_id;

    public GameInfoTable() {
        super();
    }

    public GameInfoTable(String game_id, String game_date, String season, String away_team_id, String home_team_id) {
        super();
        this.game_id = game_id;
        this.game_date = game_date;
        this.season = season;
        this.away_team_id = away_team_id;
        this.home_team_id = home_team_id;
    }

    public String getGame_date() {
        return game_date;
    }

    public void setGame_date(String game_date) {
        this.game_date = game_date;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getAway_team_id() {
        return away_team_id;
    }

    public void setAway_team_id(String away_team_id) {
        this.away_team_id = away_team_id;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getHome_team_id() {
        return home_team_id;
    }

    public void setHome_team_id(String home_team_id) {
        this.home_team_id = home_team_id;
    }
}

