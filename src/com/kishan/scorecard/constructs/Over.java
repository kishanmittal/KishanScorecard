package com.kishan.scorecard.constructs;

import java.util.ArrayList;
import java.util.List;

public class Over {

    private List<Ball> balls;
    private boolean isComplete;

    public Over() {
        this.balls = new ArrayList<>();
        isComplete = false;
    }

    public void addBallToOver(Ball ball) {
        balls.add(ball);
    }

    public void setOverComplete() {
        this.isComplete = true;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
