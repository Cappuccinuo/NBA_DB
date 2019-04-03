package com.example.easynotes.exception;

public class TeamBackgroundNotFoundException extends Exception {
    private String team_id;

    public TeamBackgroundNotFoundException(String team_id) {
        super(String.format("Book is not found with id : '%s'", team_id));
    }
}
