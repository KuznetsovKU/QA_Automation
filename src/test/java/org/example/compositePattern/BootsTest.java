package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BootsTest extends AbstractTest{

    @ParameterizedTest
    @ValueSource(ints = {42, 44, 43, 41})
    void checkSize (int size) {
        //given
        int currentSize = size;
        //when
        Boots boots = new Boots(BootsTypes.OFFICIAL.name(), size);
        //then
        Assertions.assertEquals(currentSize, boots.getSize());
    }

    @ParameterizedTest
    @EnumSource(BootsTypes.class)
    void checkType (BootsTypes type) {
        //given
        String currentBrand = type.name();
        //when
        Boots boots = new Boots(type.name(), 43);
        //then
        Assertions.assertEquals(currentBrand, boots.getType());
    }
}
