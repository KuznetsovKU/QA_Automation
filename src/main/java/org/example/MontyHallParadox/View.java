package org.example.MontyHallParadox;

import java.util.List;

public class View {
    private static View instance;

    public static View getInstance() {
        if (instance == null) {
            return new View();
        }
        return instance;
    }

    private View() {
    }

    public void greeting(List<Door> scene) {
        System.out.println(" - Lady's & Gentleman, wellcome to our show!");
        System.out.println("Monty presents scene:");
        for (Door door: scene) {
            doorMeeting(door);
        }
        System.out.println();
    }

    public void presentPlayersDoor(Door door) {
        if (door.containsPrise()) {
            System.out.println(" - Congratulations! This door contains your Prize!");
        } else {
            System.out.println(" - Sorry, but this door contains nothing...");
        }
        System.out.println(" - Well, our game is finished. See you next time!");
        System.out.println();
    }

    public void presentEmptyDoor(int doorNumber) {
        System.out.println(" - Now it's my turn...");
        System.out.println("Monty open the door number " + getHumanityNumber(doorNumber));
        System.out.println(" - Well, fortunately for you, this door is empty...");
        System.out.println(" - Would you like to change your choice?");
        System.out.println();
    }

    public void announcePlayersChoice(int doorNumber, String playerName) {
        System.out.println(" - Ok! " + playerName + " chose the door number " + getHumanityNumber(doorNumber));

    }

    private int getHumanityNumber(int num) {
        return num + 1;
    }

    private void doorMeeting(Door door) {
        String containsPrize;
        if (door.containsPrise()) {
            containsPrize = " contains prize";
        } else {
            containsPrize = " is empty";
        }
        System.out.println(" - The door number " + getHumanityNumber(door.getDoorNumber()) + containsPrize);
    }

}
