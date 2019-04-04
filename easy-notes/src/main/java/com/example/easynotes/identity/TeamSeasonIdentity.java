package com.example.easynotes.identity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// https://www.callicoder.com/hibernate-spring-boot-jpa-composite-primary-key-example/

@Embeddable
public class TeamSeasonIdentity implements Serializable {
    @NotNull
    private String team_id;

    @NotNull
    private String season;

    public TeamSeasonIdentity() {

    }

    public TeamSeasonIdentity(String team_id, String season) {
        this.team_id = team_id;
        this.season = season;
    }

    public String getTeam_id() {
        return this.team_id;
    }

    public String getSeason() {
        return this.season;
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
        TeamSeasonIdentity that = (TeamSeasonIdentity) o;

        if (!team_id.equals(that.team_id)) {
            return false;
        }
        return season.equals(that.season);
    }
}
