package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ToothBrashTest extends AbstractTest{

    @ParameterizedTest
    @EnumSource(ToothBrashBrandNames.class)
    void checkBrandName (ToothBrashBrandNames name) {
        //given
        String currentBrand = name.name();
        //when
        ToothBrash toothBrash = new ToothBrash(name.name());
        //then
        Assertions.assertEquals(currentBrand, toothBrash.getBrandName());
    }
}
