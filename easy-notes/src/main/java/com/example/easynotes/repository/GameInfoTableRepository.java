package com.example.easynotes.repository;

import com.example.easynotes.model.GameInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameInfoTableRepository extends JpaRepository<GameInfoTable, String> {
}