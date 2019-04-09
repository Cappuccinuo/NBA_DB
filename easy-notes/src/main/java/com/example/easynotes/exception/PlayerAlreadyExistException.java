package com.example.easynotes.exception;

public class PlayerAlreadyExistException extends Exception {
    private String person_id;

    public PlayerAlreadyExistException(String person_id) {
        super(String.format("Player is already exist found with id : '%s'", person_id));
    }
}