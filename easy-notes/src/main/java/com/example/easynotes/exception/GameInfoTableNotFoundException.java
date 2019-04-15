package com.example.easynotes.exception;

public class GameInfoTableNotFoundException extends Exception {
    private String game_id;

    public GameInfoTableNotFoundException(String game_id) {
        super(String.format("Game info is not found with game_id : '%s'",
               game_id));
    }
}
