package com.example.easynotes.identity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class PlayerGameIdentity implements Serializable {
    @NotNull
    private String team_id;

    @NotNull
    private String game_id;

    @NotNull
    private String player_id;

    public PlayerGameIdentity() {

    }

    public PlayerGameIdentity(String player_id, String team_id, String game_id) {
        this.player_id = player_id;
        this.team_id = team_id;
        this.game_id = game_id;
    }

    public String getPlayer_id() {
        return this.player_id;
    }

    public String getTeam_id() {
        return this.team_id;
    }

    public String getGame_id() {
        return this.game_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerGameIdentity that = (PlayerGameIdentity) o;

        if (!team_id.equals(that.team_id)) {
            return false;
        }
        if (!player_id.equals(that.player_id)) {
            return false;
        }
        return game_id.equals(that.game_id);
    }
}
