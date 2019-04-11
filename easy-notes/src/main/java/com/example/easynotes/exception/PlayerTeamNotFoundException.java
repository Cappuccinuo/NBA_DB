package com.example.easynotes.exception;

public class PlayerTeamNotFoundException extends Exception {
   private String player_id;

    public PlayerTeamNotFoundException(String player_id) {
        super(String.format("Team Season is not found with person_id : '%s'",
                player_id));
    }
}