package org.example.MontyHallParadox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SceneBuilder {
    private final List<Door> doors = new ArrayList<>();

    public SceneBuilder(int doorsCounter, int gotPrize) {
        buildScene(doorsCounter, gotPrize);
    }

    private void buildScene(int doorsCounter, int gotPrize){
        for (int i = 0; i < gotPrize; i++) {
            this.doors.add(new Door(true));
        }
        for (int i = 0; i < doorsCounter - gotPrize; i++) {
            doors.add(new Door(false));
        }
        Collections.shuffle(doors);
        for (int i = 0; i < doors.size(); i++) {
            doors.get(i).setDoorNumber(i);
        }
    }

    public List<Door> getDoors() {
        return doors;
    }

}
