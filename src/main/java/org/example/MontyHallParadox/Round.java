package org.example.MontyHallParadox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Round {
    private final Random random = new Random();
    private final View view = View.getInstance();
    private final Game game;
    private final List<Door> scene;
    private final Player player;
    private List<Integer> notChosenList;
    private Door playersDoor;

    public Round(Game game) {
        this.game = game;
        this.scene = game.getScene();
        this.player = game.getPlayer();
        this.notChosenList = getNotChosenList();
    }

    public void playGame() {
        view.greeting(scene);
        playersStep();
        while (thereAreFreeDoors()) {
            montysStep();
            changePlayersChoice();
        }
        playersStep();
        view.presentPlayersDoor(playersDoor);
    }
    
    private void playersStep() {
        int playerChoice = notChosenList.get(random.nextInt(notChosenList.size()));
        for (Door door: scene) {
            if (!door.isOpen() && !door.isChosen() && door.getDoorNumber() == playerChoice) {
                playersDoor = door;
                door.setIsChosen(true);
                view.announcePlayersChoice(door.getDoorNumber(), this.player.getName());
            }
        }
        notChosenList = getNotChosenList();
    }
    
    private void montysStep() {
        if (thereAreFreeDoors()) {
            for (Door door: scene) {
                if (!door.isOpen() && !door.isChosen() && !door.containsPrise()) {
                    door.setIsOpen(true);
                    view.presentEmptyDoor(door.getDoorNumber());
                    break;
                }
            }
        }
        notChosenList = getNotChosenList();
    }

    private void changePlayersChoice() {
        if (this.player.isAgreeToChange() && thereAreFreeDoors()) {
            playersDoor.setIsChosen(false);
            playersStep();
        }
    }

    private List<Integer> getNotChosenList() {
        List<Integer> notChosenList = new ArrayList<>();
        for (Door door: game.getScene()) {
            if (!door.isOpen() && !door.isChosen()) {
                notChosenList.add(door.getDoorNumber());
            }
        }
        return notChosenList;
    }

    private boolean thereAreFreeDoors() {
        return notChosenList.size() > 1;
    }

    public boolean isWinn() {
        return playersDoor.containsPrise();
    }
}
