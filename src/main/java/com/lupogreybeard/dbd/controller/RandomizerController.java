package com.lupogreybeard.dbd.controller;

import com.lupogreybeard.dbd.model.Character;
import com.lupogreybeard.dbd.repository.CharacterRepository;
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
    private final Random random = new Random();

    @Autowired
    public RandomizerController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/killer")
    public Character getRandomKiller() {
        List<Character> killers = characterRepository.findByType("Killer");
        return killers.get(random.nextInt(killers.size()));
    }

    @GetMapping("/survivor")
    public Character getRandomSurvivor() {
        List<Character> survivors = characterRepository.findByType("Survivor");
        return survivors.get(random.nextInt(survivors.size()));
    }
}
