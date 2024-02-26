package org.example.MontyHallParadox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

public class DoorTest extends AbstractTest {

    @Test
    void createPrizeDoor() {
        //given
        boolean hidePrize = true;
        //when
        Door door = new Door(hidePrize);
        //then
        Assertions.assertTrue(door.containsPrise());
    }

    @Test
    void createNoPrizeDoor() {
        //given
        boolean hidePrize = false;
        //when
        Door door = new Door(hidePrize);
        //then
        Assertions.assertFalse(door.containsPrise());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void checkIsChosen(boolean hidePrize) {
        //given
        //when
        Door door = new Door(hidePrize);
        //then
        Assertions.assertFalse(door.isChosen());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void checkIsOpen(boolean hidePrize) {
        //given
        //when
        Door door = new Door(hidePrize);
        //then
        Assertions.assertFalse(door.isOpen());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void checkDoorNumber(boolean hidePrize) {
        //given
        //when
        Door door = new Door(hidePrize);
        //then
        Assertions.assertNull(door.getDoorNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 3, 4, 5})
    void checkDoorNumberAfterSetting(int doorNumbers) {
        //given
        Random random = new Random();
        boolean hidePrize = random.nextBoolean();
        //when
        Door door = new Door(hidePrize);
        door.setDoorNumber(doorNumbers);
        //then
        Assertions.assertEquals(doorNumbers, door.getDoorNumber());
    }
}
