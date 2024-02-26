package org.example.MontyHallParadox;

public class Door {
    private final boolean hidePrize;
    private Integer doorNumber;
    private boolean isChosen;
    private boolean isOpen;

    public Door(boolean hidePrize) {
        this.hidePrize = hidePrize;
        this.isChosen = false;
        this.isOpen = false;
    }

    public boolean containsPrise() {
        return hidePrize;
    }

    public Integer getDoorNumber() {
        return this.doorNumber;
    }

    public void setDoorNumber(int num) {
        this.doorNumber = num;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setIsChosen(boolean chosen) {
        isChosen = chosen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean open) {
        isOpen = open;
    }

}
