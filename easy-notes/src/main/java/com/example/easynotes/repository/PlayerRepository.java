package com.example.easynotes.repository;

import com.example.easynotes.model.Book;
import com.example.easynotes.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
}