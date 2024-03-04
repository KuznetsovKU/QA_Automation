package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JeansTest extends AbstractTest{

    @ParameterizedTest
    @ValueSource(ints = {42, 44, 53, 54})
    void checkSize (int size) {
        //given
        int currentSize = size;
        //when
        Jeans jeans = new Jeans(JeansBrandNames.CK.toString(), size);
        //then
        Assertions.assertEquals(currentSize, jeans.getSize());
    }

    @ParameterizedTest
    @EnumSource(JeansBrandNames.class)
    void checkBrandName (JeansBrandNames name) {
        //given
        String currentBrand = name.name();
        //when
        Jeans jeans = new Jeans(name.name(), 50);
        //then
        Assertions.assertEquals(currentBrand, jeans.getBrandName());
    }
}
