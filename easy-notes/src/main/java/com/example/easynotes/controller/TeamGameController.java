package com.example.easynotes.controller;

import com.example.easynotes.dao.GameInfoDao;
import com.example.easynotes.exception.TeamGameNotFoundException;
import com.example.easynotes.identity.TeamGameIdentity;
import com.example.easynotes.model.GameInfo;
import com.example.easynotes.model.TeamGame;
import com.example.easynotes.model.TeamGameInfo;
import com.example.easynotes.repository.TeamGameRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value="team game", description="Stats of a team in one game.")
public class TeamGameController {
    @Autowired
    TeamGameRepository teamGameRepository;
    @Autowired
    GameInfoDao gameInfoDao;

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
    public List<TeamGameInfo> getNumTeamGame(@PathVariable(value="team_id") String team_id,
                                             @PathVariable(value="num") String num) {
        List<TeamGameInfo> teamGameInfos = new LinkedList<>();
        List<TeamGame> teamGames = teamGameRepository.getNumTeamGame(team_id, Integer.parseInt(num));
        for (TeamGame teamGame : teamGames) {
            GameInfo gameInfo = gameInfoDao.getGamesGivenId(teamGame.getTeamGameIdentity().getGame_id());
            teamGameInfos.add(new TeamGameInfo(gameInfo, teamGame));
        }
        return teamGameInfos;
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