package com.example.easynotes.controller;

import com.example.easynotes.exception.PlayerTeamNotFoundException;
import com.example.easynotes.model.*;
import com.example.easynotes.repository.PlayerRepository;
import com.example.easynotes.repository.PlayerTeamRepository;
import com.example.easynotes.repository.TeamBackgroundRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value="player team", description="Mapping of player and team")
public class PlayerTeamController {
    @Autowired
    PlayerTeamRepository playerTeamRepository;
    @Autowired
    TeamBackgroundRepository teamBackgroundRepository;
    @Autowired
    PlayerRepository playerRepository;

    @ApiOperation(value = "Get all mapping of player and team", response = List.class)
    @GetMapping("/playerteam")
    public List<PlayerTeam> getAllPlayerTeam() {
        return playerTeamRepository.findAll();
    }

    @ApiOperation(value = "Create a new relationship of player and team")
    @PostMapping("/playerteam")
    public PlayerTeam createPlayerTeam(@RequestBody PlayerTeam playerTeam) {
        return playerTeamRepository.save(playerTeam);
    }

    @ApiOperation(value = "Get the team information of a player")
    @GetMapping("playerteam/team/{player_id}")
    public TeamBackground getPlayerTeamByPlayer(@PathVariable(value = "player_id") String player_id) {
        return teamBackgroundRepository.getTeamOfPlayer(player_id);
    }

    @ApiOperation(value = "Get all players of a given team")
    @GetMapping("/playerteam/players/{team_id}")
    public List<Player> getAllTeamPlayers(@PathVariable(value = "team_id") String teamId) {
        return playerRepository.getAllTeamPlayer(teamId);
    }

    @ApiOperation(value = "Update an existing player's team")
    @PutMapping("/playerteam/{player_id}")
    public PlayerTeam updatePlayerTeam(@PathVariable(value = "player_id") String player_id,
                                           @RequestBody PlayerTeam playerTeamDetails) throws PlayerTeamNotFoundException {
        PlayerTeam playerTeam = playerTeamRepository.findById(player_id).orElseThrow(() -> new
                PlayerTeamNotFoundException(player_id));
        playerTeam.setTeam_id(playerTeamDetails.getTeam_id());
        PlayerTeam updatedPlayerTeam = playerTeamRepository.save(playerTeam);
        return updatedPlayerTeam;
    }

    @ApiOperation(value = "Delete the relationship of player-team")
    @DeleteMapping("/playerteam/{player_id}")
    public ResponseEntity<?> deletePlayerTeam(@PathVariable(value = "player_id") String player_id)
            throws PlayerTeamNotFoundException {
        PlayerTeam playerTeam = playerTeamRepository.findById(player_id).orElseThrow(() -> new
                PlayerTeamNotFoundException(player_id));
        playerTeamRepository.delete(playerTeam);
        return ResponseEntity.ok().build();
    }
}
