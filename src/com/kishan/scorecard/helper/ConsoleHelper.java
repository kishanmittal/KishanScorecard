package com.kishan.scorecard.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {

    private static final Scanner in =  new Scanner(System.in);

    public static void printPrompt(String message){
        System.out.println(message);
    }

    public static int readInteger(){
        int num = in.nextInt();
        in.nextLine();
        return num;
    }

    public static String readString(){
        return in.nextLine();
    }

    public static List<String> readPlayerRoster(int numberOfPlayers){
        List<String> playerRoster = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            String player = in.nextLine();
            playerRoster.add(player);
        }
        return playerRoster;
    }

    public static void close(){
        in.close();;
    }
}
