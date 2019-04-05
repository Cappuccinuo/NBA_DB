package com.example.easynotes.controller;

import com.example.easynotes.exception.TeamSeasonNotFoundException;
import com.example.easynotes.identity.TeamSeasonIdentity;
import com.example.easynotes.model.TeamSeason;
import com.example.easynotes.repository.TeamSeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamSeasonController {
    @Autowired
    TeamSeasonRepository teamSeasonRepository;

    @GetMapping("/teamseason")
    public List<TeamSeason> getAllTeamSeason() {
        return teamSeasonRepository.findAll();
    }

    @PostMapping("/teamseason")
    public TeamSeason createTeamSeason(@RequestBody TeamSeason teamSeason) {
        return teamSeasonRepository.save(teamSeason);
    }

    @GetMapping("/teamseason/{team_id}&{season}")
    public TeamSeason getTeamSeasonById(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season)
            throws TeamSeasonNotFoundException {
        return teamSeasonRepository.findById(new TeamSeasonIdentity(team_id, season)).orElseThrow(() -> new
                TeamSeasonNotFoundException(new TeamSeasonIdentity(team_id, season)));
    }

    @PutMapping("/teamseason/{team_id}&{season}")
    public TeamSeason updateTeamSeason(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season,
                           @RequestBody TeamSeason teamSeasonDetails) throws TeamSeasonNotFoundException {
        TeamSeason teamSeason = teamSeasonRepository.findById(new TeamSeasonIdentity(team_id, season)).orElseThrow(() -> new
                TeamSeasonNotFoundException(new TeamSeasonIdentity(team_id, season)));

        TeamSeason updatedTeamSeason = teamSeasonRepository.save(teamSeason);
        return updatedTeamSeason;
    }

    @DeleteMapping("/teamseason/{team_id}&{season}")
    public ResponseEntity<?> deleteTeamSeason(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season,)
            throws TeamSeasonNotFoundException {
        TeamSeason teamSeason = teamSeasonRepository.findById(new TeamSeasonIdentity(team_id, season)).orElseThrow(() -> new
                TeamSeasonNotFoundException(new TeamSeasonIdentity(team_id, season)));
        teamSeasonRepository.delete(teamSeason);
        return ResponseEntity.ok().build();
    }
}
