package com.example.easynotes.controller;

import com.example.easynotes.exception.PlayerSeasonNotFoundException;
import com.example.easynotes.identity.PlayerSeasonIdentity;
import com.example.easynotes.model.PlayerSeason;
import com.example.easynotes.repository.PlayerSeasonRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value="player season", description="Stats of a player during entire season.")
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
    public PlayerSeason getPlayerSeasonById(@PathVariable(value = "player_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season)
            throws PlayerSeasonNotFoundException {
        return playerSeasonRepository.findById(new PlayerSeasonIdentity(player_id, team_id, season)).orElseThrow(() -> new
                PlayerSeasonNotFoundException(new PlayerSeasonIdentity(player_id, team_id, season)));
    }

    @PutMapping("/playerseason/{player_id}&{team_id}&{season}")
    public PlayerSeason updatePlayerSeason(@PathVariable(value = "player_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season,
                                       @RequestBody PlayerSeason playerSeasonDetails) throws PlayerSeasonNotFoundException {
        PlayerSeason playerSeason = playerSeasonRepository.findById(new PlayerSeasonIdentity(player_id, team_id, season)).orElseThrow(() -> new
                PlayerSeasonNotFoundException(new PlayerSeasonIdentity(player_id, team_id, season)));

        PlayerSeason updatedPlayerSeason = playerSeasonRepository.save(playerSeason);
        updatedPlayerSeason.setAst(playerSeasonDetails.getAst());
        updatedPlayerSeason.setBlk(playerSeasonDetails.getBlk());
        updatedPlayerSeason.setD_reb(playerSeasonDetails.getD_reb());
        updatedPlayerSeason.setO_reb(playerSeasonDetails.getO_reb());
        updatedPlayerSeason.setReb(playerSeasonDetails.getReb());
        updatedPlayerSeason.setFg3a(playerSeasonDetails.getFg3a());
        updatedPlayerSeason.setFg3m(playerSeasonDetails.getFg3m());
        updatedPlayerSeason.setFg3_pct(playerSeasonDetails.getFg3_pct());
        updatedPlayerSeason.setFga(playerSeasonDetails.getFga());
        updatedPlayerSeason.setFgm(playerSeasonDetails.getFgm());
        updatedPlayerSeason.setFg_pct(playerSeasonDetails.getFg_pct());
        updatedPlayerSeason.setFta(playerSeasonDetails.getFta());
        updatedPlayerSeason.setFtm(playerSeasonDetails.getFtm());
        updatedPlayerSeason.setFt_pct(playerSeasonDetails.getFt_pct());
        updatedPlayerSeason.setMin(playerSeasonDetails.getMin());
        updatedPlayerSeason.setTov(playerSeasonDetails.getTov());
        updatedPlayerSeason.setStl(playerSeasonDetails.getStl());
        updatedPlayerSeason.setPts(playerSeasonDetails.getPts());
        updatedPlayerSeason.setPf(playerSeasonDetails.getPf());
        return updatedPlayerSeason;
    }

    @DeleteMapping("/playerseason/{player_id}&{team_id}&{season}")
    public ResponseEntity<?> deletePlayerSeason(@PathVariable(value = "player_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season)
            throws PlayerSeasonNotFoundException {
        PlayerSeason playerSeason = playerSeasonRepository.findById(new PlayerSeasonIdentity(player_id, team_id, season)).orElseThrow(() -> new
                PlayerSeasonNotFoundException(new PlayerSeasonIdentity(player_id, team_id, season)));
        playerSeasonRepository.delete(playerSeason);
        return ResponseEntity.ok().build();
    }
}
