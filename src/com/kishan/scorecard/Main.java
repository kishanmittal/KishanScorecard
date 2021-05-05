package com.kishan.scorecard;

import com.kishan.scorecard.helper.ConsoleHelper;

import java.util.List;

import static com.kishan.scorecard.helper.Constants.TEAM1;
import static com.kishan.scorecard.helper.Constants.TEAM2;

public class Main {

    public static void main(String[] args) {

        ConsoleHelper.printPrompt("Enter number of players for each team :");
        int numberOfPlayers = ConsoleHelper.readInteger();

        ConsoleHelper.printPrompt("Enter number of overs :");
        int numberOfOvers = ConsoleHelper.readInteger();

        CricketApplication cricketApplication = new CricketApplication(numberOfPlayers, numberOfOvers);

        ConsoleHelper.printPrompt("Enter batting order for Team 1 :");
        List<String> team1Players = ConsoleHelper.readPlayerRoster(numberOfPlayers);
        cricketApplication.configureTeam(TEAM1, team1Players);

        cricketApplication.playInnings(TEAM1);

        ConsoleHelper.printPrompt("Enter batting order for Team 2 :");
        List<String> team2Players = ConsoleHelper.readPlayerRoster(numberOfPlayers);
        cricketApplication.configureTeam(TEAM2, team2Players);

        cricketApplication.playInnings(TEAM2);

        cricketApplication.displayMatchResult();

        ConsoleHelper.close();
    }

}
