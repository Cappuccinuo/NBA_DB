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
    private String abbreviation;
    private String nickname;
    private String year_founded;
    private String city;
    private String arena;
    private String arena_capacity;
    private String owner;
    private String general_manager;
    private String head_coach;
    private String affiliation;
    private String facebook;
    private String instagram;
    private String twitter;

    public TeamBackground() {
        super();
    }

    public TeamBackground(String id, String abbreviation, String nickname, String year_founded,
                           String city, String arena, String arena_capacity, String owner,
                          String general_manager, String head_coach, String affiliation,
                          String facebook, String instagram, String twitter) {
        super();
        this.team_id = id;
        this.abbreviation = abbreviation;
        this.nickname = nickname;
        this.year_founded = year_founded;
        this.city = city;
        this.arena = arena;
        this.arena_capacity = arena_capacity;
        this.owner = owner;
        this.general_manager = general_manager;
        this.head_coach = head_coach;
        this.affiliation = affiliation;
        this.facebook = facebook;
        this.instagram = instagram;
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTeam_id() {
        return this.team_id;
    }
    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getYear_founded() {
        return this.year_founded;
    }
    public void setYear_founded(String year_founded) {
        this.year_founded = year_founded;
    }

    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getArena() {
        return this.arena;
    }
    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getArena_capacity() {
        return this.arena_capacity;
    }
    public void setArena_capacity(String arena_capacity) {
        this.arena_capacity = arena_capacity;
    }

    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getGeneral_manager() {
        return this.general_manager;
    }
    public void setGeneral_manager(String general_manager) {
        this.general_manager = general_manager;
    }

    public String getHead_coach() {
        return this.head_coach;
    }
    public void setHead_coach(String head_coach) {
        this.head_coach = head_coach;
    }

    public String getAffiliation() {
        return this.affiliation;
    }
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
}
