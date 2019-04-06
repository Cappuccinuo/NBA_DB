package com.example.easynotes.repository;

import com.example.easynotes.model.Player;
import com.example.easynotes.model.TeamBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamBackgroundRepository extends JpaRepository<TeamBackground, String> {

}