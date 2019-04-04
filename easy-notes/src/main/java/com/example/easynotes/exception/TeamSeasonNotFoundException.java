package com.example.easynotes.exception;

import com.example.easynotes.identity.TeamSeasonIdentity;
import com.example.easynotes.model.TeamSeason;

public class TeamSeasonNotFoundException extends Exception {
    private TeamSeasonIdentity teamSeasonIdentity;

    public TeamSeasonNotFoundException(TeamSeasonIdentity teamSeasonIdentity) {
        super(String.format("Team Season is not found with team_id : '%s', season : '%s'", teamSeasonIdentity.getTeam_id(), teamSeasonIdentity.getSeason()));
    }
}