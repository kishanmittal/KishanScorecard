package com.kishan.scorecard.innings;

import com.kishan.scorecard.entities.Team;
import com.kishan.scorecard.constructs.Over;

import java.util.ArrayList;
import java.util.List;

public class Innings {

    protected int wickets;
    protected int score;
    protected int currentBalls;
    protected Team playingTeam;
    protected Over currentOver;
    protected List<Over> overs;

    public Innings(Team playingTeam) {
        this.playingTeam = playingTeam;
        this.wickets = 0;
        this.score = 0;
        this.currentBalls = 0;
        this.currentOver = new Over();
        this.overs = new ArrayList<>();
    }

    public Team getPlayingTeam() {
        return this.playingTeam;
    }

    public int getScore(){
        return score;
    }

    public int getWickets(){
        return wickets;
    }

}
