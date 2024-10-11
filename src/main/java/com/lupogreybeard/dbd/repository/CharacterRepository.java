package com.lupogreybeard.dbd.repository;

import com.lupogreybeard.dbd.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    // Find characters by type (Killer or Survivor)
    List<Character> findByType(String type);
}
