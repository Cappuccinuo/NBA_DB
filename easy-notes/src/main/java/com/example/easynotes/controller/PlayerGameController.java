package com.example.easynotes.controller;

import com.example.easynotes.dao.GameInfoDao;
import com.example.easynotes.exception.PlayerGameNotFoundException;
import com.example.easynotes.identity.PlayerGameIdentity;
import com.example.easynotes.model.GameInfo;
import com.example.easynotes.model.Player;
import com.example.easynotes.model.PlayerGame;
import com.example.easynotes.model.PlayerGameInfo;
import com.example.easynotes.repository.PlayerGameRepository;
import com.example.easynotes.repository.PlayerRepository;
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
@Api(value="player game", description="Stats of a player in one game.")
public class PlayerGameController {
    @Autowired
    PlayerGameRepository playerGameRepository;
    @Autowired
    TeamGameRepository teamGameRepository;
    @Autowired
    GameInfoDao gameInfoDao;
    @Autowired
    PlayerRepository playerRepository;

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

    @ApiOperation(value= "Get the latest first num game of giving player")
    @GetMapping("/playergame/{player_id}/latest{num}")
    public List<PlayerGameInfo> getNumPlayerGame(@PathVariable(value="player_id") String player_id,
                                                 @PathVariable(value="num") String num) {
        List<PlayerGame> playerGames = playerGameRepository.getNumPlayerGame(player_id, Integer.parseInt(num));

        List<PlayerGameInfo> playerGameInfos = new LinkedList<>();
        for (PlayerGame playerGame : playerGames) {
            String game_id = playerGame.getPlayerGameIdentity().getGame_id();
            GameInfo gameInfo = gameInfoDao.getGamesGivenId(game_id);
            Player player = playerRepository.findById(playerGame.getPlayerGameIdentity().getPlayer_id()).get();
            playerGameInfos.add(new PlayerGameInfo(gameInfo, player, playerGame));
        }
        return playerGameInfos;
    }

    @PutMapping("/playergame/{player_id}&{team_id}&{game_id}")
    public PlayerGame updatePlayerGame(@PathVariable(value = "player_id") String player_id, @PathVariable(value = "team_id") String team_id, @PathVariable(value = "game_id") String game_id,
                                           @RequestBody PlayerGame playerGameDetails) throws PlayerGameNotFoundException {
        PlayerGame playerGame = playerGameRepository.findById(new PlayerGameIdentity(player_id, team_id, game_id)).orElseThrow(() -> new
                PlayerGameNotFoundException(new PlayerGameIdentity(player_id, team_id, game_id)));
        
        playerGame.setAst(playerGameDetails.getAst());
        playerGame.setBlk(playerGameDetails.getBlk());
        playerGame.setD_reb(playerGameDetails.getD_reb());
        playerGame.setO_reb(playerGameDetails.getO_reb());
        playerGame.setReb(playerGameDetails.getReb());
        playerGame.setFg3a(playerGameDetails.getFg3a());
        playerGame.setFg3m(playerGameDetails.getFg3m());
        playerGame.setFg3_pct(playerGameDetails.getFg3_pct());
        playerGame.setFga(playerGameDetails.getFga());
        playerGame.setFgm(playerGameDetails.getFgm());
        playerGame.setFg_pct(playerGameDetails.getFg_pct());
        playerGame.setFta(playerGameDetails.getFta());
        playerGame.setFtm(playerGameDetails.getFtm());
        playerGame.setFt_pct(playerGameDetails.getFt_pct());
        playerGame.setMin(playerGameDetails.getMin());
        playerGame.setTov(playerGameDetails.getTov());
        playerGame.setStl(playerGameDetails.getStl());
        playerGame.setPlus_minus(playerGameDetails.getPlus_minus());
        playerGame.setPts(playerGameDetails.getPts());
        playerGame.setStart_position(playerGameDetails.getStart_position());
        playerGame.setPf(playerGameDetails.getPf());
        PlayerGame updatedPlayerGame = playerGameRepository.save(playerGame);
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
