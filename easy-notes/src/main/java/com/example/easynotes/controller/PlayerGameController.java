package com.example.easynotes.controller;

import com.example.easynotes.exception.PlayerGameNotFoundException;
import com.example.easynotes.identity.PlayerGameIdentity;
import com.example.easynotes.model.PlayerGame;
import com.example.easynotes.repository.PlayerGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PlayerGameController {
    @Autowired
    PlayerGameRepository playerGameRepository;

    @GetMapping("/playergame")
    public List<PlayerGame> getAllPlayerGame() {
        return playerGameRepository.findAll();
    }

    @PostMapping("/playergame")
    public PlayerGame createPlayerGame(@RequestBody PlayerGame playerGame) {
        return playerGameRepository.save(playerGame);
    }

    @GetMapping("/playergame/{player_id}&{team_id}&{game_id}")
    public PlayerGame getPlayerGameById(@PathVariable(value = "player_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id)
            throws PlayerGameNotFoundException {
        return playerGameRepository.findById(new PlayerGameIdentity(player_id, team_id, game_id)).orElseThrow(() -> new
                PlayerGameNotFoundException(new PlayerGameIdentity(player_id, team_id, game_id)));
    }

    @PutMapping("/playergame/{player_id}&{team_id}&{game_id}")
    public PlayerGame updatePlayerGame(@PathVariable(value = "player_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id,
                                           @RequestBody PlayerGame playerGameDetails) throws PlayerGameNotFoundException {
        PlayerGame playerGame = playerGameRepository.findById(new PlayerGameIdentity(player_id, team_id, game_id)).orElseThrow(() -> new
                PlayerGameNotFoundException(new PlayerGameIdentity(player_id, team_id, game_id)));

        PlayerGame updatedPlayerGame = playerGameRepository.save(playerGame);
        updatedPlayerGame.setAst(playerGameDetails.getAst());
        updatedPlayerGame.setBlk(playerGameDetails.getBlk());
        updatedPlayerGame.setD_reb(playerGameDetails.getD_reb());
        updatedPlayerGame.setO_reb(playerGameDetails.getO_reb());
        updatedPlayerGame.setReb(playerGameDetails.getReb());
        updatedPlayerGame.setFg3a(playerGameDetails.getFg3a());
        updatedPlayerGame.setFg3m(playerGameDetails.getFg3m());
        updatedPlayerGame.setFg3_pct(playerGameDetails.getFg3_pct());
        updatedPlayerGame.setFga(playerGameDetails.getFga());
        updatedPlayerGame.setFgm(playerGameDetails.getFgm());
        updatedPlayerGame.setFg_pct(playerGameDetails.getFg_pct());
        updatedPlayerGame.setFta(playerGameDetails.getFta());
        updatedPlayerGame.setFtm(playerGameDetails.getFtm());
        updatedPlayerGame.setFt_pct(playerGameDetails.getFt_pct());
        updatedPlayerGame.setMin(playerGameDetails.getMin());
        updatedPlayerGame.setTov(playerGameDetails.getTov());
        updatedPlayerGame.setStl(playerGameDetails.getStl());
        updatedPlayerGame.setPlus_minus(playerGameDetails.getPlus_minus());
        updatedPlayerGame.setPts(playerGameDetails.getPts());
        updatedPlayerGame.setStart_position(playerGameDetails.getStart_position());
        updatedPlayerGame.setPf(playerGameDetails.getPf());
        return updatedPlayerGame;
    }

    @DeleteMapping("/playergame/{player_id}&{team_id}&{game_id}")
    public ResponseEntity<?> deletePlayerGame(@PathVariable(value = "player_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id)
            throws PlayerGameNotFoundException {
        PlayerGame playerGame = playerGameRepository.findById(new PlayerGameIdentity(player_id, team_id, game_id)).orElseThrow(() -> new
                PlayerGameNotFoundException(new PlayerGameIdentity(player_id, team_id, game_id)));
        playerGameRepository.delete(playerGame);
        return ResponseEntity.ok().build();
    }
}
