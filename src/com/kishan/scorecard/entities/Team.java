package com.kishan.scorecard.entities;

import java.util.HashMap;

public class Team {

    private String teamName;
    private int numberOfPlayers;
    private int score;
    private HashMap<Integer, Player> teamPlayers;

    public Team(String teamName, int numberOfPlayers, HashMap<Integer, Player> teamPlayers) {
        this.teamName = teamName;
        this.numberOfPlayers = numberOfPlayers;
        this.teamPlayers = teamPlayers;
        this.score = 0;
    }

    public HashMap<Integer, Player> getTeamPlayers() {
        return teamPlayers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }
}
