package com.example.easynotes.exception;

public class PlayerNotFoundException extends Exception {
    private String person_id;

    public PlayerNotFoundException(String person_id) {
        super(String.format("Book is not found with id : '%s'", person_id));
    }
}