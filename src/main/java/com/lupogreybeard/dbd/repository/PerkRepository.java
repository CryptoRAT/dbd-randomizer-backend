package com.lupogreybeard.dbd.repository;

import com.lupogreybeard.dbd.model.Perk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerkRepository extends JpaRepository<Perk, Long> {

    // Find perks by type (Killer or Survivor)
    List<Perk> findByType(String type);
}
