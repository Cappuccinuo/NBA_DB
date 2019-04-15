package com.example.easynotes.exception;

public class GameInfoTableAlreadyExistException extends Exception {
    private String game_id;

    public GameInfoTableAlreadyExistException(String game_id) {
        super(String.format("Game Info Table is already exist found with id : '%s'", game_id));
    }
}