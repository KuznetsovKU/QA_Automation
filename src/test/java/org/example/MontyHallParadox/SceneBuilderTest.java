package org.example.MontyHallParadox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SceneBuilderTest extends AbstractTest {

    static List<Door> scene;

    @BeforeEach
    void clearScene() {
        scene = null;
    }

    @Test
    void checkSceneCreation() {
        //given
        int doorCounter = 0;
        int prizeCounter = 0;
        //when
        scene = new SceneBuilder(doorAmount, prizeAmount).getDoors();
        for (Door door : scene) {
            if (door.containsPrise()) {
                prizeCounter++;
            }
            doorCounter++;
        }

        int finalDoorCounter = doorCounter;
        int finalPrizeCounter = prizeCounter;
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(doorAmount, finalDoorCounter),
                () -> Assertions.assertEquals(prizeAmount, finalPrizeCounter)
        );
    }

}
