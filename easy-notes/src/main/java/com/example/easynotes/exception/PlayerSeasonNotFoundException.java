package com.example.easynotes.exception;

import com.example.easynotes.identity.PlayerSeasonIdentity;

public class PlayerSeasonNotFoundException extends Exception {
    private PlayerSeasonIdentity playerSeasonIdentity;

    public PlayerSeasonNotFoundException(PlayerSeasonIdentity playerSeasonIdentity) {
        super(String.format("Team Season is not found with player_id : '%s', team_id : '%s', season : '%s'",
                playerSeasonIdentity.getPlayer_id(), playerSeasonIdentity.getTeam_id(), playerSeasonIdentity.getSeason()));
    }
}