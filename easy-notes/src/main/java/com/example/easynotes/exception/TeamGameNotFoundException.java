package com.example.easynotes.exception;

import com.example.easynotes.identity.TeamGameIdentity;

public class TeamGameNotFoundException extends Exception {
    private TeamGameIdentity teamGameIdentity;

    public TeamGameNotFoundException(TeamGameIdentity teamGameIdentity) {
        super(String.format("Team Game is not found with team_id : '%s', game_id : '%s'", teamGameIdentity.getTeam_id(), teamGameIdentity.getGame_id()));
    }
}
