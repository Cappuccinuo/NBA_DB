package com.example.easynotes.controller;

import com.example.easynotes.exception.TeamBackgroundNotFoundException;
import com.example.easynotes.model.TeamBackground;
import com.example.easynotes.repository.TeamBackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamBackgroundController {
    @Autowired
    TeamBackgroundRepository teamBackgroundRepository;

    @GetMapping("/teambg")
    public List<TeamBackground> getAllNotes() {
        return teamBackgroundRepository.findAll();
    }

    @PostMapping("/teambg")
    public TeamBackground createNote(@RequestBody TeamBackground tb) {
        return teamBackgroundRepository.save(tb);
    }

    @GetMapping("/teambg/{id}")
    public TeamBackground getNoteById(@PathVariable(value = "id") String teamId)
            throws TeamBackgroundNotFoundException {
        return teamBackgroundRepository.findById(teamId).orElseThrow(() -> new
                TeamBackgroundNotFoundException(teamId));
    }

    @PutMapping("/teambg/{id}")
    public TeamBackground updateNote(@PathVariable(value = "id") String teamId,
                           @RequestBody TeamBackground teamDetails) throws TeamBackgroundNotFoundException {
        TeamBackground tb = teamBackgroundRepository.findById(teamId).orElseThrow(() -> new
                TeamBackgroundNotFoundException(teamId));

        tb.setAbbrevation(teamDetails.getAbbrevation());
        tb.setAffiliation(teamDetails.getAffiliation());
        tb.setArena(teamDetails.getArena());
        tb.setArena_capacity(teamDetails.getArena_capacity());
        tb.setCity(teamDetails.getCity());
        tb.setGeneral_manager(teamDetails.getGeneral_manager());
        tb.setHead_coach(teamDetails.getHead_coach());
        tb.setNickname(teamDetails.getNickname());
        tb.setOwner(teamDetails.getOwner());
        tb.setYear_founded(teamDetails.getYear_founded());
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
