package com.kishan.scorecard.constructs;

public class Ball {

    private static final String WICKET = "W";
    private static final String NO_BALL = "N";
    private static final String WIDE = "Wd";
    private static final int FOUR = 4;
    private static final int SIX = 6;

    private String ball;

    public Ball(String ball) {
        this.ball = ball;
    }

    public boolean isWicketBall() {
        return WICKET.equals(ball);
    }

    public boolean isNoBall() {
        return NO_BALL.equals(ball);
    }

    public boolean isWideBall() {
        return WIDE.equals(ball);
    }

    public boolean isBoundary() {
        int runs = getValueForBall();
        return FOUR == runs;
    }

    public boolean isSix() {
        int runs = getValueForBall();
        return SIX == runs;
    }

    public int getValueForBall() {
        return Integer.parseInt(ball);
    }
}
