package com.example.easynotes.controller;
import com.example.easynotes.dao.GameInfoDao;
import com.example.easynotes.model.GameInfo;
import com.example.easynotes.repository.TeamGameRepository;
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
    TeamGameRepository teamGameRepository;
    @Autowired
    GameInfoDao gameInfoDao;

    @ApiOperation(value= "Get all games in database")
    @GetMapping("/game/{date}")
    public List<GameInfo> getAllGameOnDate(@PathVariable(value="date") String date) {
        return gameInfoDao.getGamesOnDate(date);
    }
}
