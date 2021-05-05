package com.kishan.scorecard;

import com.kishan.scorecard.helper.ConsoleHelper;
import com.kishan.scorecard.entities.Batsman;
import com.kishan.scorecard.entities.Player;
import com.kishan.scorecard.entities.Team;
import com.kishan.scorecard.constructs.Ball;
import com.kishan.scorecard.innings.Batting;
import com.kishan.scorecard.innings.Innings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.kishan.scorecard.helper.Constants.TEAM1;
import static com.kishan.scorecard.helper.Constants.TEAM2;

public class CricketApplication {

    private final int numberOfOvers;
    private final int numberOfPlayersPerTeam;
    private final HashMap<String, Team> playingTeams;
    private final List<Innings> matchInnings;
    private ScoreBoard scoreBoard;

    public CricketApplication(int numberOfPlayersPerTeam, int numberOfOvers) {
        this.numberOfPlayersPerTeam = numberOfPlayersPerTeam;
        this.numberOfOvers = numberOfOvers;
        this.playingTeams = new HashMap<>();
        this.matchInnings = new ArrayList<>();
    }

    public void configureTeam(String teamName, List<String> orderOfPlayers) {
        int position = 1;
        HashMap<Integer, Player> teamPlayers = new HashMap<>();

        for (String playerId : orderOfPlayers) {
            Player teamPlayer = new Batsman(playerId, position);
            teamPlayers.put(position, teamPlayer);
            position++;
        }

        final Team participatingTeam = new Team(teamName, orderOfPlayers.size(), teamPlayers);
        this.playingTeams.put(teamName, participatingTeam);
    }

    public void playInnings(String teamName) {
        final Team playingTeam = playingTeams.get(teamName);
        final Batting innings = new Batting(playingTeam);

        initializeScoreboard(innings);

        int currentOvers = 1;
        while (currentOvers <= numberOfOvers) {
            ConsoleHelper.printPrompt("Over " + currentOvers);
            while (true) {
                String nextBall = ConsoleHelper.readString();
                Ball ball = new Ball(nextBall);
                innings.playBall(ball);

                if (innings.isOverComplete()) {
                    displayScoreboard();
                    break;
                }

                if(innings.isTeamAllOut()){
                    displayScoreboard();
                    break;
                }
            }

            if(innings.isTeamAllOut()){
                break;
            }

            currentOvers++;
        }

        playingTeam.setScore(innings.getScore());
        matchInnings.add(innings);
    }

    public void displayMatchResult() {
        int scoreForTeam1 = playingTeams.get(TEAM1).getScore();
        int scoreForTeam2 = playingTeams.get(TEAM2).getScore();
        int diff = Math.abs(scoreForTeam1 - scoreForTeam2);
        if (scoreForTeam1 > scoreForTeam2) {
            ConsoleHelper.printPrompt("Team 1 wins by " + diff + " runs");
        } else if (scoreForTeam2 > scoreForTeam1) {
            ConsoleHelper.printPrompt("Team 2 wins by " + diff + " runs");
        } else {
            ConsoleHelper.printPrompt("Super Over !");
        }
    }

    private void initializeScoreboard(Innings innings) {
        this.scoreBoard = new ScoreBoard(innings);
    }

    private void displayScoreboard() {
        this.scoreBoard.display();
    }

}
