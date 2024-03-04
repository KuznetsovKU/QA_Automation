package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ToothPasteTest extends AbstractTest{

    @ParameterizedTest
    @EnumSource(ToothPasteBrandNames.class)
    void checkBrandName (ToothPasteBrandNames name) {
        //given
        String currentBrand = name.name();
        //when
        ToothPaste toothPaste = new ToothPaste(name.name());
        //then
        Assertions.assertEquals(currentBrand, toothPaste.getBrandName());
    }
}
