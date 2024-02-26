package org.example.MontyHallParadox;

public class Program {

    public static void main(String[] args) {

        int roundAmount = 1000;
        int winnCounter = 0;

        for (int i = 0; i < roundAmount; i++) {
            Game game = new Game(3, 1, "John", true);
            Round round = new Round(game);
            round.playGame();
            if (round.isWinn()) {
                winnCounter++;
            }
        }
        System.out.println(" --- Statistics ---");
        System.out.println(roundAmount + " rounds was played");
        System.out.println(winnCounter + " rounds was ends with players victory");
    }
}
