package com.kishan.scorecard.entities;

/**
 * Alternate - Use OnStrike attribute ?
 */
public class Batsman extends Player {

    private int position;
    private int score;
    private int numberOfFours;
    private int numberOfSixes;

    public Batsman(String id, int position) {
        super(id);
        this.position = position;
        this.score = 0;
        this.numberOfFours = 0;
        this.numberOfSixes = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public void incrementFours() {
        this.numberOfFours += 1;
    }

    public void incrementSixes() {
        this.numberOfSixes += 1;
    }

    public int getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getNumberOfFours() {
        return numberOfFours;
    }

    public int getNumberOfSixes() {
        return numberOfSixes;
    }

}
