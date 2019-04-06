package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "player")
@EntityListeners(AuditingEntityListener.class)

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private String person_id;
    private String first_name;
    private String last_name;
    private String name;
    private String birthdate;
    private String school;
    private String country;
    private String height;
    private String weight;
    private String position;
    private String rosterstatus;
    private String team_id;
    private String from_year;
    private String to_year;
    private String draft_year;
    private String draft_round;
    private String draft_number;

    public Player() {
        super();
    }

    public Player(String id, String first_name, String last_name, String name,
                  String birthdate, String school, String country, String height,
                  String weight, String position, String rosterstatus,
                  String team_id, String from_year, String to_year,
                  String draft_year, String draft_round, String draft_number) {
        super();
        this.person_id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.name = name;
        this.birthdate = birthdate;
        this.school = school;
        this.country = country;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.rosterstatus = rosterstatus;
        this.team_id = team_id;
        this.from_year = from_year;
        this.to_year = to_year;
        this.draft_year = draft_year;
        this.draft_round = draft_round;
        this.draft_number = draft_number;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPerson_id() {
        return this.person_id;
    }
    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getFirst_name() {
        return this.first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeight() {
        return this.height;
    }
    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return this.weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getRosterstatus() {
        return this.rosterstatus;
    }
    public void setRosterstatus(String rosterstatus) {
        this.rosterstatus = rosterstatus;
    }

    public String getTeam_id() {
        return this.team_id;
    }
    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getFrom_year() {
        return this.from_year;
    }
    public void setFrom_year(String from_year) {
        this.from_year = from_year;
    }

    public String getTo_year() {
        return this.to_year;
    }
    public void setTo_year(String to_year) {
        this.to_year = to_year;
    }

    public String getDraft_year() {
        return this.draft_year;
    }
    public void setDraft_year(String draft_year) {
        this.draft_year = draft_year;
    }

    public String getDraft_round() {
        return this.draft_round;
    }
    public void setDraft_round(String draft_round) {
        this.draft_round = draft_round;
    }

    public String getDraft_number() {
        return this.draft_number;
    }
    public void setDraft_number(String draft_number) {
        this.draft_number = draft_number;
    }
}
