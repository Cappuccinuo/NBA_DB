package com.example.easynotes.controller;

import com.example.easynotes.exception.PlayerNotFoundException;
import com.example.easynotes.model.Player;
import com.example.easynotes.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/player")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/player")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/player/{id}")
    public Player getPlayerById(@PathVariable(value = "id") String personId)
            throws PlayerNotFoundException {
        return playerRepository.findById(personId).orElseThrow(() -> new
                PlayerNotFoundException(personId));
    }

    @PutMapping("/player/{id}")
    public Player updatePlayer(@PathVariable(value = "id") String personId,
                           @RequestBody Player playerDetails) throws PlayerNotFoundException {
        Player player = playerRepository.findById(personId).orElseThrow(() -> new
                PlayerNotFoundException(personId));

        player.setCountry(playerDetails.getCountry());
        player.setDraft_number(playerDetails.getDraft_number());
        player.setDraft_round(playerDetails.getDraft_round());
        player.setDraft_year(playerDetails.getDraft_year());
        player.setFirst_name(playerDetails.getFirst_name());
        player.setLast_name(playerDetails.getLast_name());
        player.setName(playerDetails.getName());
        player.setFrom_year(playerDetails.getFrom_year());
        player.setTo_year(playerDetails.getTo_year());
        player.setTeam_id(playerDetails.getTeam_id());
        player.setHeight(playerDetails.getHeight());
        player.setWeight(playerDetails.getWeight());
        player.setRosterstatus(playerDetails.getRosterstatus());
        player.setPosition(playerDetails.getPosition());
        player.setSchool(playerDetails.getSchool());
        Player updatedPlayer = playerRepository.save(player);
        return updatedPlayer;
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") String personId)
            throws PlayerNotFoundException {
        Player player = playerRepository.findById(personId).orElseThrow(() -> new
                PlayerNotFoundException(personId));
        playerRepository.delete(player);
        return ResponseEntity.ok().build();
    }
}
