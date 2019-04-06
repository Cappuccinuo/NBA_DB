package com.example.easynotes.exception;

import com.example.easynotes.identity.PlayerGameIdentity;

public class PlayerGameNotFoundException extends Exception {
    private PlayerGameIdentity playerGameIdentity;

    public PlayerGameNotFoundException(PlayerGameIdentity playerGameIdentity) {
        super(String.format("Team Season is not found with player_id : '%s', team_id : '%s', game_id : '%s'",
                playerGameIdentity.getPlayer_id(), playerGameIdentity.getTeam_id(), playerGameIdentity.getGame_id()));
    }
}