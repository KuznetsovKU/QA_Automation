package org.example.MontyHallParadox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest extends AbstractTest{

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkDoorsOnScene(int doorsCount) {
        //given
        //when
        Game game = new Game(doorsCount, prizeAmount, playerName, true);
        //then
        Assertions.assertEquals(doorsCount, game.getScene().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkPrizeOnScene(int prizeCount) {
        //given
        int res = 0;
        //when
        Game game = new Game(10, prizeCount, playerName, true);
        for (Door door : game.getScene()) {
            if (door.containsPrise()) {
                res++;
            }
        }
        //then
        Assertions.assertEquals(prizeCount, res);
    }

    @ParameterizedTest
    @EnumSource(Names.class)
    void checkPlayerName(Names name) {
        //given
        String currentName = name.name();
        //when
        Game game = new Game(doorAmount, prizeAmount, name.name(), true);
        //then
        Assertions.assertEquals(currentName, game.getPlayer().getName());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void checkPlayerRiskTaking(boolean riskTaking) {
        //given
        //when
        Game game = new Game(doorAmount, prizeAmount, playerName, riskTaking);
        //then
        Assertions.assertEquals(riskTaking, game.getPlayer().isAgreeToChange());
    }
}
