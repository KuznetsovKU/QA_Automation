package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ShampooTest extends AbstractTest{

    @ParameterizedTest
    @EnumSource(ShampooBrandNames.class)
    void checkBrandName (ShampooBrandNames name) {
        //given
        String currentBrand = name.name();
        //when
        Shampoo shampoo = new Shampoo(name.name());
        //then
        Assertions.assertEquals(currentBrand, shampoo.getBrandName());
    }
}
