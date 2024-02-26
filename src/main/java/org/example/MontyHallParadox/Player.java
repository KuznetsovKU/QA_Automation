package org.example.MontyHallParadox;

public class Player {
    private final String name;
    private final boolean agreeToChange;

    public Player(String name, boolean agreeToChange) {
        this.name = name;
        this.agreeToChange = agreeToChange;
    }

    public String getName() {
        return name;
    }

    public boolean isAgreeToChange() {
        return agreeToChange;
    }
}
