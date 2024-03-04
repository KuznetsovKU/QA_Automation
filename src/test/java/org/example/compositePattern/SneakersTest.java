package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SneakersTest extends AbstractTest{

    @ParameterizedTest
    @ValueSource(ints = {42, 44, 43, 41})
    void checkSize (int size) {
        //given
        int currentSize = size;
        //when
        Sneakers sneakers = new Sneakers(SneakersBrandName.ADIDAS.name(), size);
        //then
        Assertions.assertEquals(currentSize, sneakers.getSize());
    }

    @ParameterizedTest
    @EnumSource(SneakersBrandName.class)
    void checkType (SneakersBrandName name) {
        //given
        String currentBrand = name.name();
        //when
        Sneakers sneakers = new Sneakers(name.name(), 43);
        //then
        Assertions.assertEquals(currentBrand, sneakers.getBrandName());
    }
}
