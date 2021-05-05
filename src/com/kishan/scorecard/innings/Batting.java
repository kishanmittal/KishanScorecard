package com.kishan.scorecard.innings;

import com.kishan.scorecard.entities.Batsman;
import com.kishan.scorecard.entities.Team;
import com.kishan.scorecard.constructs.Ball;
import com.kishan.scorecard.constructs.Over;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kishan.scorecard.helper.Constants.OVER_SIZE;

public class Batting extends Innings {

    private final List<Batsman> playingBatsman;
    private boolean isTeamAllOut;

    public Batting(final Team playingTeam) {
        super(playingTeam);
        playingBatsman = new ArrayList<>();
        playingBatsman.add((Batsman) playingTeam.getTeamPlayers().get(1));
        playingBatsman.add((Batsman) playingTeam.getTeamPlayers().get(2));
        isTeamAllOut = false;
    }

    public void playBall(final Ball ball) {

        Batsman currentBatsman = playingBatsman.get(0);

        if (currentOver.isComplete()) {
            currentOver = new Over();
            currentBalls = 0;
        }

        if (ball.isWicketBall()) {
            wickets++;
            int position = 2 + wickets;
            if(position > playingTeam.getNumberOfPlayers()){
                isTeamAllOut = true;
                return;
            }
            playingBatsman.remove(0);
            playingBatsman.add(0, (Batsman) playingTeam.getTeamPlayers().get(position));
            currentBalls++;
            currentOver.addBallToOver(ball);
        }
        else if (ball.isNoBall()) {
            score = score + 1;
            currentOver.addBallToOver(ball);
        }
        else if (ball.isWideBall()) {
            score = score + 1;
            currentOver.addBallToOver(ball);
        }
        else {
            int runs = ball.getValueForBall();
            currentBatsman.addToScore(runs);
            score += runs;
            if (ball.isBoundary()) {
                currentBatsman.incrementFours();
            } else if (ball.isSix()) {
                currentBatsman.incrementSixes();
            }

            if (runs % 2 == 1) {
                Collections.swap(playingBatsman, 0, 1);
            }

            currentBalls++;
            currentOver.addBallToOver(ball);
        }

        if (currentBalls == OVER_SIZE) {
            currentOver.setOverComplete();
            overs.add(currentOver);
            Collections.swap(playingBatsman, 0, 1);
        }

    }

    public boolean isOverComplete() {
        return currentOver.isComplete();
    }

    public boolean isTeamAllOut(){
        return isTeamAllOut;
    }
}
