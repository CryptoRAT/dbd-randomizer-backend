package com.lupogreybeard.dbd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Perk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;  // You might use an enum here in the future

    @Column(name = "lore")
    private String lore;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Character owner;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Character getOwner() {
        return this.owner;
    }

    public void setOwner(Character owner) {
        this.owner = owner;
    }
}
