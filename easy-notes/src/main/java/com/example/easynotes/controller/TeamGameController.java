package com.example.easynotes.controller;
import com.example.easynotes.exception.TeamGameNotFoundException;
import com.example.easynotes.identity.TeamGameIdentity;
import com.example.easynotes.model.TeamGame;
import com.example.easynotes.repository.TeamGameRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value="team game", description="Stats of a team in one game.")
public class TeamGameController {
    @Autowired
    TeamGameRepository teamGameRepository;

    @ApiOperation(value= "Get all games in database")
    @GetMapping("/teamgame")
    public List<TeamGame> getAllTeamGame() {
        return teamGameRepository.findAll();
    }

    @ApiOperation(value= "Get all games played by giving team")
    @GetMapping("/teamgame/{team_id}")
    public List<TeamGame> getAllTeamGame(@PathVariable(value="team_id") String team_id) {
        return teamGameRepository.getAllTeamGame(team_id);
    }

    @ApiOperation(value= "Get the latest first num game of giving team")
    @GetMapping("/teamgame/{team_id}/latest{num}")
    public List<TeamGame> getNumTeamGame(@PathVariable(value="team_id") String team_id,
                                         @PathVariable(value="num") String num) {
        return teamGameRepository.getNumTeamGame(team_id, new PageRequest(0, Integer.parseInt(num)));
    }

    @ApiOperation(value= "Create a new game")
    @PostMapping("/teamgame")
    public TeamGame createTeamGame(@RequestBody TeamGame teamGame) {
        return teamGameRepository.save(teamGame);
    }

    @ApiOperation(value= "Get specific game played by a team")
    @GetMapping("/teamgame/{team_id}/{game_id}")
    public TeamGame getTeamGameById(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id)
            throws TeamGameNotFoundException {
        return teamGameRepository.findById(new TeamGameIdentity(team_id, game_id)).orElseThrow(() -> new
                TeamGameNotFoundException(new TeamGameIdentity(team_id, game_id)));
    }

    @ApiOperation(value= "Update specific game played by a team")
    @PutMapping("/teamgame/{team_id}/{game_id}")
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

    @ApiOperation(value= "Delete specific game played by a team")
    @DeleteMapping("/teamgame/{team_id}/{game_id}")
    public ResponseEntity<?> deleteTeamGame(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id)
            throws TeamGameNotFoundException {
        TeamGame teamGame = teamGameRepository.findById(new TeamGameIdentity(team_id, game_id)).orElseThrow(() -> new
                TeamGameNotFoundException(new TeamGameIdentity(team_id, game_id)));
        teamGameRepository.delete(teamGame);
        return ResponseEntity.ok().build();
    }
}