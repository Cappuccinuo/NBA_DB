package com.example.easynotes.controller;

import com.example.easynotes.exception.PlayerSeasonNotFoundException;
import com.example.easynotes.identity.PlayerSeasonIdentity;
import com.example.easynotes.model.PlayerSeason;
import com.example.easynotes.repository.PlayerSeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerSeasonController {
    @Autowired
    PlayerSeasonRepository playerSeasonRepository;

    @GetMapping("/playerseason")
    public List<PlayerSeason> getAllPlayerSeason() {
        return playerSeasonRepository.findAll();
    }

    @PostMapping("/playerseason")
    public PlayerSeason createPlayerSeason(@RequestBody PlayerSeason playerSeason) {
        return playerSeasonRepository.save(playerSeason);
    }

    @GetMapping("/playerseason/{player_id}&{team_id}&{season}")
    public PlayerSeason getPlayerSeasonById(@PathVariable(value = "team_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season)
            throws PlayerSeasonNotFoundException {
        return playerSeasonRepository.findById(new PlayerSeasonIdentity(player_id, team_id, season)).orElseThrow(() -> new
                PlayerSeasonNotFoundException(new PlayerSeasonIdentity(player_id, team_id, season)));
    }

    @PutMapping("/playerseason/{player_id}&{team_id}&{season}")
    public PlayerSeason updatePlayerSeason(@PathVariable(value = "team_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season,
                                       @RequestBody PlayerSeason playerSeasonDetails) throws PlayerSeasonNotFoundException {
        PlayerSeason playerSeason = playerSeasonRepository.findById(new PlayerSeasonIdentity(player_id, team_id, season)).orElseThrow(() -> new
                PlayerSeasonNotFoundException(new PlayerSeasonIdentity(player_id, team_id, season)));

        PlayerSeason updatedPlayerSeason = playerSeasonRepository.save(playerSeason);
        return updatedPlayerSeason;
    }

    @DeleteMapping("/playerseason/{player_id}&{team_id}&{season}")
    public ResponseEntity<?> deletePlayerSeason(@PathVariable(value = "team_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season)
            throws PlayerSeasonNotFoundException {
        PlayerSeason playerSeason = playerSeasonRepository.findById(new PlayerSeasonIdentity(player_id, team_id, season)).orElseThrow(() -> new
                PlayerSeasonNotFoundException(new PlayerSeasonIdentity(player_id, team_id, season)));
        playerSeasonRepository.delete(playerSeason);
        return ResponseEntity.ok().build();
    }
}
