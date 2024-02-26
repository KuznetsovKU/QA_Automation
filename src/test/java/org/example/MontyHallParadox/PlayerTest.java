package org.example.MontyHallParadox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class PlayerTest extends AbstractTest{


    @ParameterizedTest
    @EnumSource(Names.class)
    void checkNames(Names name) {
        //given
        String currentName = name.name();
        //when
        Player player = new Player(name.name(), true);
        //then
        Assertions.assertEquals(currentName, player.getName());
    }

    @Test
    void createRiskPlayer() {
        //given
        //when
        Player player = new Player(playerName, true);
        //then
        Assertions.assertTrue(player.isAgreeToChange());
    }

    @Test
    void createNoRiskPlayer() {
        //given
        //when
        Player player = new Player(playerName, false);
        //then
        Assertions.assertFalse(player.isAgreeToChange());
    }

}
