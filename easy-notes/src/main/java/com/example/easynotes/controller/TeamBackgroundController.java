package com.example.easynotes.controller;

import com.example.easynotes.exception.TeamBackgroundNotFoundException;
import com.example.easynotes.model.Player;
import com.example.easynotes.model.TeamBackground;
import com.example.easynotes.repository.PlayerRepository;
import com.example.easynotes.repository.TeamBackgroundRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value="teamBackground", description="All information of a team.")
public class TeamBackgroundController {
    @Autowired
    TeamBackgroundRepository teamBackgroundRepository;

    @GetMapping("/teambg")
    public List<TeamBackground> getAllTeamBGs() {
        return teamBackgroundRepository.findAll();
    }

    @PostMapping("/teambg")
    public TeamBackground createTeamBG(@RequestBody TeamBackground tb) {
        return teamBackgroundRepository.save(tb);
    }

    @GetMapping("/teambg/{id}")
    public TeamBackground getTeamBGById(@PathVariable(value = "id") String teamId)
            throws TeamBackgroundNotFoundException {
        return teamBackgroundRepository.findById(teamId).orElseThrow(() -> new
                TeamBackgroundNotFoundException(teamId));
    }

    @PutMapping("/teambg/{id}")
    public TeamBackground updateTeamBG(@PathVariable(value = "id") String teamId,
                           @RequestBody TeamBackground teamDetails) throws TeamBackgroundNotFoundException {
        TeamBackground tb = teamBackgroundRepository.findById(teamId).orElseThrow(() -> new
                TeamBackgroundNotFoundException(teamId));

        tb.setAbbreviation(teamDetails.getAbbreviation());
        tb.setAffiliation(teamDetails.getAffiliation());
        tb.setArena(teamDetails.getArena());
        tb.setArena_capacity(teamDetails.getArena_capacity());
        tb.setCity(teamDetails.getCity());
        tb.setGeneral_manager(teamDetails.getGeneral_manager());
        tb.setHead_coach(teamDetails.getHead_coach());
        tb.setNickname(teamDetails.getNickname());
        tb.setOwner(teamDetails.getOwner());
        tb.setYear_founded(teamDetails.getYear_founded());
        tb.setFacebook(teamDetails.getFacebook());
        tb.setInstagram(teamDetails.getInstagram());
        tb.setTwitter(teamDetails.getTwitter());
        TeamBackground updatedTB = teamBackgroundRepository.save(tb);

        return updatedTB;
    }

    @DeleteMapping("/teambg/{id}")
    public ResponseEntity<?> deleteTeamBackground(@PathVariable(value = "id") String teamId)
            throws TeamBackgroundNotFoundException {
        TeamBackground tb = teamBackgroundRepository.findById(teamId).orElseThrow(() -> new
                TeamBackgroundNotFoundException(teamId));
        teamBackgroundRepository.delete(tb);
        return ResponseEntity.ok().build();
    }
}
