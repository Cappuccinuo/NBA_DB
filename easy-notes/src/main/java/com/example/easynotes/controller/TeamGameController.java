package com.example.easynotes.controller;
import com.example.easynotes.exception.TeamGameNotFoundException;
import com.example.easynotes.identity.TeamGameIdentity;
import com.example.easynotes.model.TeamGame;
import com.example.easynotes.repository.TeamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamGameController {
    @Autowired
    TeamGameRepository teamGameRepository;

    @GetMapping("/teamgame")
    public List<TeamGame> getAllTeamGame() {
        return teamGameRepository.findAll();
    }

    @PostMapping("/teamgame")
    public TeamGame createTeamGame(@RequestBody TeamGame teamGame) {
        return teamGameRepository.save(teamGame);
    }

    @GetMapping("/teamgame/{team_id}&{game_id}")
    public TeamGame getTeamGameById(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id)
            throws TeamGameNotFoundException {
        return teamGameRepository.findById(new TeamGameIdentity(team_id, game_id)).orElseThrow(() -> new
                TeamGameNotFoundException(new TeamGameIdentity(team_id, game_id)));
    }

    @PutMapping("/teamgame/{team_id}&{game_id}")
    public TeamGame updateTeamGame(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id,
                                       @RequestBody TeamGame teamGameDetails) throws TeamGameNotFoundException {
        TeamGame teamGame = teamGameRepository.findById(new TeamGameIdentity(team_id, game_id)).orElseThrow(() -> new
                TeamGameNotFoundException(new TeamGameIdentity(team_id, game_id)));

        TeamGame updatedTeamGame = teamGameRepository.save(teamGame);
        return updatedTeamGame;
    }

    @DeleteMapping("/teamgame/{team_id}&{game_id}")
    public ResponseEntity<?> deleteTeamGame(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id)
            throws TeamGameNotFoundException {
        TeamGame teamGame = teamGameRepository.findById(new TeamGameIdentity(team_id, game_id)).orElseThrow(() -> new
                TeamGameNotFoundException(new TeamGameIdentity(team_id, game_id)));
        teamGameRepository.delete(teamGame);
        return ResponseEntity.ok().build();
    }
}