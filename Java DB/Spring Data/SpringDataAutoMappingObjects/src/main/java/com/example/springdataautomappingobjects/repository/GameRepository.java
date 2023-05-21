package com.example.springdataautomappingobjects.repository;

import com.example.springdataautomappingobjects.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
