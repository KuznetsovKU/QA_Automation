package org.example.MontyHallParadox;

import java.util.List;

public class Game {
    private final List<Door> scene;
    private final Player player;

    public Game(int doorsCounter, int gotPrize, String playerName, boolean agreementToChange) {
        this.scene = new SceneBuilder(doorsCounter, gotPrize).getDoors();
        this.player = new Player(playerName, agreementToChange);
    }

    public List<Door> getScene() {
        return this.scene;
    }

    public Player getPlayer() {
        return this.player;
    }
}
