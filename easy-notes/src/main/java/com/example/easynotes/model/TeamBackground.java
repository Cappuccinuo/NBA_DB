package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "team_background")
@EntityListeners(AuditingEntityListener.class)

public class TeamBackground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private String team_id;
    private String abbrevation;
    private String nickname;
    private String year_founded;
    private String city;
    private String arena;
    private String arena_capacity;
    private String owner;
    private String general_manager;
    private String head_coach;
    private String affiliation;

    public TeamBackground() {
        super();
    }

    public TeamBackground(String id, String abbrevation, String nickname, String year_founded,
                           String city, String arena, String arena_capacity, String owner,
                          String general_manager, String head_coach, String affiliation) {
        super();
        this.team_id = id;
        this.abbrevation = abbrevation;
        this.nickname = nickname;
        this.year_founded = year_founded;
        this.city = city;
        this.arena = arena;
        this.arena_capacity = arena_capacity;
        this.owner = owner;
        this.general_manager = general_manager;
        this.head_coach = head_coach;
        this.affiliation = affiliation;
    }

    private String getTeam_id() {
        return this.team_id;
    }
    private void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    private String getAbbrevation() {
        return this.abbrevation;
    }
    private void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }

    private String getNickname() {
        return this.nickname;
    }
    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String getYear_founded() {
        return this.year_founded;
    }
    private void setYear_founded(String year_founded) {
        this.year_founded = year_founded;
    }

    private String getCity() {
        return this.city;
    }
    private void setCity(String city) {
        this.city = city;
    }

    private String getArena() {
        return this.arena;
    }
    private void setArena(String arena) {
        this.arena = arena;
    }

    private String getArena_capacity() {
        return this.arena_capacity;
    }
    private void setArena_capacity(String arena_capacity) {
        this.arena_capacity = arena_capacity;
    }

    private String getOwner() {
        return this.owner;
    }
    private void setOwner(String owner) {
        this.owner = owner;
    }

    private String getGeneral_manager() {
        return this.general_manager;
    }
    private void setGeneral_manager(String general_manager) {
        this.general_manager = general_manager;
    }

    private String getHead_coach() {
        return this.head_coach;
    }
    private void setHead_coach(String head_coach) {
        this.head_coach = head_coach;
    }

    private String getAffiliation() {
        return this.affiliation;
    }
    private void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
}
