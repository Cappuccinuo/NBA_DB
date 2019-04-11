package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "player_team")
@EntityListeners(AuditingEntityListener.class)

public class PlayerTeam {
    @Id
    @NotBlank
    private String player_id;
    private String team_id;

    public PlayerTeam() {
        super();
    }

    public PlayerTeam(String player_id, String team_id) {
        super();
        this.player_id = player_id;
        this.team_id = team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_id() {
        return player_id;
    }
}
