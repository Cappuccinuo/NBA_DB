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
        updatedTeamGame.setAst(teamGameDetails.getAst());
        updatedTeamGame.setBlk(teamGameDetails.getBlk());
        updatedTeamGame.setD_reb(teamGameDetails.getD_reb());
        updatedTeamGame.setO_reb(teamGameDetails.getO_reb());
        updatedTeamGame.setReb(teamGameDetails.getReb());
        updatedTeamGame.setFg3a(teamGameDetails.getFg3a());
        updatedTeamGame.setFg3m(teamGameDetails.getFg3m());
        updatedTeamGame.setFg3_pct(teamGameDetails.getFg3_pct());
        updatedTeamGame.setFga(teamGameDetails.getFga());
        updatedTeamGame.setFgm(teamGameDetails.getFgm());
        updatedTeamGame.setFg_pct(teamGameDetails.getFg_pct());
        updatedTeamGame.setFta(teamGameDetails.getFta());
        updatedTeamGame.setFtm(teamGameDetails.getFtm());
        updatedTeamGame.setFt_pct(teamGameDetails.getFt_pct());
        updatedTeamGame.setMin(teamGameDetails.getMin());
        updatedTeamGame.setTov(teamGameDetails.getTov());
        updatedTeamGame.setStl(teamGameDetails.getStl());
        updatedTeamGame.setPts(teamGameDetails.getPts());
        updatedTeamGame.setPf(teamGameDetails.getPf());
        updatedTeamGame.setGame_date(teamGameDetails.getGame_date());
        updatedTeamGame.setMatchup(teamGameDetails.getMatchup());
        updatedTeamGame.setWl(teamGameDetails.getWl());
        updatedTeamGame.setSeason(teamGameDetails.getSeason());
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