package com.kishan.scorecard.entities;

/**
 * Extend to batting and bowling props
 */
public class Player {

    private String id;
    private String name;

    public Player(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
