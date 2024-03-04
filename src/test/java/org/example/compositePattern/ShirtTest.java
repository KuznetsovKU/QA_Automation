package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ShirtTest extends AbstractTest{

    @ParameterizedTest
    @ValueSource(ints = {42, 44, 53, 54})
    void checkSize (int size) {
        //given
        int currentSize = size;
        //when
        Shirt shirt = new Shirt(ShirtBrandNames.CK.toString(), size);
        //then
        Assertions.assertEquals(currentSize, shirt.getSize());
    }

    @ParameterizedTest
    @EnumSource(ShirtBrandNames.class)
    void checkBrandName (ShirtBrandNames name) {
        //given
        String currentBrand = name.name();
        //when
        Shirt shirt = new Shirt(name.name(), 50);
        //then
        Assertions.assertEquals(currentBrand, shirt.getBrandName());
    }
}
