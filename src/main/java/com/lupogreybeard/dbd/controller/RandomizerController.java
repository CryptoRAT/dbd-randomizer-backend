package com.lupogreybeard.dbd.controller;

import com.lupogreybeard.dbd.model.Character;
import com.lupogreybeard.dbd.model.Perk;
import com.lupogreybeard.dbd.repository.CharacterRepository;
import com.lupogreybeard.dbd.repository.PerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/random")
public class RandomizerController {

    private final CharacterRepository characterRepository;
    private final PerkRepository perkRepository;
    private final Random random = new Random();

    @Autowired
    public RandomizerController(CharacterRepository characterRepository, PerkRepository perkRepository) {
        this.characterRepository = characterRepository;
        this.perkRepository = perkRepository;
    }

    @GetMapping("/character/killer")
    public Character getRandomKiller() {
        List<Character> killers = characterRepository.findByType("Killer");
        return killers.get(random.nextInt(killers.size()));
    }

    @GetMapping("/character/survivor")
    public Character getRandomSurvivor() {
        List<Character> survivors = characterRepository.findByType("Survivor");
        return survivors.get(random.nextInt(survivors.size()));
    }

    @GetMapping("/perk/killer")
    public List<Perk> getRandomKillerPerkLoadout() {
        List<Perk> perks = perkRepository.findByType("Killer");
        return perks;
    }

    @GetMapping("/perk/survivor")
    public List<Perk> getRandomPerkLoadout() {
        List<Perk> perks = perkRepository.findByType("Survivor");
        return perks;
    }
}
