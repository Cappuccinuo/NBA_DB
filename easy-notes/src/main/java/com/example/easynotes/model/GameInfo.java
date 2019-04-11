package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//  Could not locate appropriate constructor on class  -> Type mismatch https://stackoverflow.com/questions/24160817/getting-error-could-not-locate-appropriate-constructor-on-class

public class GameInfo {
    private String away_team;
    private String home_team;
    private Float away_score;
    private Float home_score;
    private String away_team_id;
    private String home_team_id;
    private String away_team_city;
    private String home_team_city;
    private String away_team_nickname;
    private String home_team_nickname;
    private String game_id;

    public GameInfo() {
        super();
    }

    public GameInfo(String away_team, String home_team, Float away_score, Float home_score, String away_team_id, String home_team_id,
                    String away_team_city, String home_team_city, String away_team_nickname, String home_team_nickname, String game_id) {
        super();
        this.away_team = away_team;
        this.home_team = home_team;
        this.away_score = away_score;
        this.home_score = home_score;
        this.away_team_id = away_team_id;
        this.home_team_id = home_team_id;
        this.away_team_city = away_team_city;
        this.home_team_city = home_team_city;
        this.away_team_nickname = away_team_nickname;
        this.home_team_nickname = home_team_nickname;
        this.game_id = game_id;
    }

    public String getAway_team_city() {
        return away_team_city;
    }

    public void setAway_team_city(String away_team_city) {
        this.away_team_city = away_team_city;
    }

    public String getAway_team_nickname() {
        return away_team_nickname;
    }

    public void setAway_team_nickname(String away_team_nickname) {
        this.away_team_nickname = away_team_nickname;
    }

    public String getHome_team_city() {
        return home_team_city;
    }

    public void setHome_team_city(String home_team_city) {
        this.home_team_city = home_team_city;
    }

    public String getHome_team_nickname() {
        return home_team_nickname;
    }

    public void setHome_team_nickname(String home_team_nickname) {
        this.home_team_nickname = home_team_nickname;
    }

    public Float getAway_score() {
        return away_score;
    }

    public void setAway_score(Float away_score) {
        this.away_score = away_score;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
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

    public Float getHome_score() {
        return home_score;
    }

    public void setHome_score(Float home_score) {
        this.home_score = home_score;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getHome_team_id() {
        return home_team_id;
    }

    public void setHome_team_id(String home_team_id) {
        this.home_team_id = home_team_id;
    }
}
