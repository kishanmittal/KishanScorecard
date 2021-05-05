package com.kishan.scorecard;

import com.kishan.scorecard.innings.Innings;
import com.kishan.scorecard.entities.Batsman;
import com.kishan.scorecard.entities.Player;
import com.kishan.scorecard.entities.Team;

public class ScoreBoard {

    private Innings innings;

    public ScoreBoard(Innings innings) {
        this.innings = innings;
    }

    public void display() {
        Team playingTeam = innings.getPlayingTeam();
        System.out.println("-------------------------------------------------------");
        System.out.format("%10s%10s%10s%10s","PLAYER NAME", "SCORE", "4s", "6s");
        System.out.println();
        System.out.println("-------------------------------------------------------");
        for (Player player : playingTeam.getTeamPlayers().values()) {
            Batsman currentPlayer = (Batsman) player;
            System.out.format("%10s%10d%10d%10d", currentPlayer.getId(), currentPlayer.getScore(), currentPlayer.getNumberOfFours(), currentPlayer.getNumberOfSixes());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Total : " + innings.getScore() + "/" + innings.getWickets());
    }
}
