package com.example.easynotes.identity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class PlayerSeasonIdentity implements Serializable {
    @NotNull
    private String team_id;

    @NotNull
    private String season;

    @NotNull
    private String player_id;

    public PlayerSeasonIdentity() {

    }

    public PlayerSeasonIdentity(String player_id, String team_id, String season) {
        this.player_id = player_id;
        this.team_id = team_id;
        this.season = season;
    }

    public String getPlayer_id() {
        return this.player_id;
    }

    public String getTeam_id() {
        return this.team_id;
    }

    public String getSeason() {
        return this.season;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerSeasonIdentity that = (PlayerSeasonIdentity) o;

        if (!team_id.equals(that.team_id)) {
            return false;
        }
        if (!player_id.equals(that.player_id)) {
            return false;
        }
        return season.equals(that.season);
    }
}
