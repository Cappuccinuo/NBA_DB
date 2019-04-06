package com.example.easynotes.controller;

import com.example.easynotes.exception.TeamSeasonNotFoundException;
import com.example.easynotes.identity.TeamSeasonIdentity;
import com.example.easynotes.model.TeamSeason;
import com.example.easynotes.repository.TeamSeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamSeasonController {
    @Autowired
    TeamSeasonRepository teamSeasonRepository;

    @GetMapping("/teamseason")
    public List<TeamSeason> getAllTeamSeason() {
        return teamSeasonRepository.findAll();
    }

    @PostMapping("/teamseason")
    public TeamSeason createTeamSeason(@RequestBody TeamSeason teamSeason) {
        return teamSeasonRepository.save(teamSeason);
    }

    @GetMapping("/teamseason/{team_id}&{season}")
    public TeamSeason getTeamSeasonById(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season)
            throws TeamSeasonNotFoundException {
        return teamSeasonRepository.findById(new TeamSeasonIdentity(team_id, season)).orElseThrow(() -> new
                TeamSeasonNotFoundException(new TeamSeasonIdentity(team_id, season)));
    }

    @PutMapping("/teamseason/{team_id}&{season}")
    public TeamSeason updateTeamSeason(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season,
                           @RequestBody TeamSeason teamSeasonDetails) throws TeamSeasonNotFoundException {
        TeamSeason teamSeason = teamSeasonRepository.findById(new TeamSeasonIdentity(team_id, season)).orElseThrow(() -> new
                TeamSeasonNotFoundException(new TeamSeasonIdentity(team_id, season)));

        TeamSeason updatedTeamSeason = teamSeasonRepository.save(teamSeason);
        updatedTeamSeason.setWin(teamSeasonDetails.getWin());
        updatedTeamSeason.setLoss(teamSeasonDetails.getLoss());
        updatedTeamSeason.setWin_percentage(teamSeasonDetails.getWin_percentage());
        updatedTeamSeason.setConf_rank(teamSeasonDetails.getConf_rank());
        updatedTeamSeason.setAst(teamSeasonDetails.getAst());
        updatedTeamSeason.setBlk(teamSeasonDetails.getBlk());
        updatedTeamSeason.setD_reb(teamSeasonDetails.getD_reb());
        updatedTeamSeason.setO_reb(teamSeasonDetails.getO_reb());
        updatedTeamSeason.setReb(teamSeasonDetails.getReb());
        updatedTeamSeason.setFg3a(teamSeasonDetails.getFg3a());
        updatedTeamSeason.setFg3m(teamSeasonDetails.getFg3m());
        updatedTeamSeason.setFg3_pct(teamSeasonDetails.getFg3_pct());
        updatedTeamSeason.setFga(teamSeasonDetails.getFga());
        updatedTeamSeason.setFgm(teamSeasonDetails.getFgm());
        updatedTeamSeason.setFg_pct(teamSeasonDetails.getFg_pct());
        updatedTeamSeason.setFta(teamSeasonDetails.getFta());
        updatedTeamSeason.setFtm(teamSeasonDetails.getFtm());
        updatedTeamSeason.setFt_pct(teamSeasonDetails.getFt_pct());
        updatedTeamSeason.setTov(teamSeasonDetails.getTov());
        updatedTeamSeason.setStl(teamSeasonDetails.getStl());
        updatedTeamSeason.setPts(teamSeasonDetails.getPts());
        updatedTeamSeason.setPf(teamSeasonDetails.getPf());
        return updatedTeamSeason;
    }

    @DeleteMapping("/teamseason/{team_id}&{season}")
    public ResponseEntity<?> deleteTeamSeason(@PathVariable(value = "team_id") String team_id, @PathVariable(value = "season") String season)
            throws TeamSeasonNotFoundException {
        TeamSeason teamSeason = teamSeasonRepository.findById(new TeamSeasonIdentity(team_id, season)).orElseThrow(() -> new
                TeamSeasonNotFoundException(new TeamSeasonIdentity(team_id, season)));
        teamSeasonRepository.delete(teamSeason);
        return ResponseEntity.ok().build();
    }
}
