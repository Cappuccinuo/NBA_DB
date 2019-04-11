package com.example.easynotes.controller;
import com.example.easynotes.dao.GameInfoDao;
import com.example.easynotes.model.GameInfo;
import com.example.easynotes.model.PlayerGame;
import com.example.easynotes.repository.PlayerGameRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value="game", description="Stats of game")
public class GameController {
    @Autowired
    GameInfoDao gameInfoDao;
    @Autowired
    PlayerGameRepository playerGameRepository;

    @ApiOperation(value= "Get all games in database")
    @GetMapping("/game/{date}")
    public List<GameInfo> getAllGameOnDate(@PathVariable(value="date") String date) {
        return gameInfoDao.getGamesOnDate(date);
    }

    @ApiOperation(value = "player-game data of all players in the specific team for the specific game.")
    @GetMapping("/game/playergames/{team_id}&{game_id}")
    public List<PlayerGame> getAllPlayerGameOfTeamAndGame(@PathVariable(value="team_id") String team_id,
                                                          @PathVariable(value="game_id") String game_id) {
        return playerGameRepository.getGamesGivenTeamAndGame(team_id, game_id);
    }
}
