package org.example.compositePattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BagTest extends AbstractTest{

    //static List<Item> bag;
    static Boots boots;
    static Jeans jeans;
    static Shampoo shampoo;
    static Shirt shirt;
    static Sneakers sneakers;
    static ToothBrash toothBrash;
    static ToothPaste toothPaste;

    @BeforeEach
    void createItems() {
        boots = new Boots(BootsTypes.OFFICIAL.name(), 44);
        jeans = new Jeans(JeansBrandNames.WRANGLER.name(), 50);
        shampoo = new Shampoo(ShampooBrandNames.AXE.name());
        shirt = new Shirt(ShirtBrandNames.ARMANY.name(), 50);
        sneakers = new Sneakers(SneakersBrandName.ADIDAS.name(), 43);
        toothBrash = new ToothBrash(ToothBrashBrandNames.XIAOMI.name());
        toothPaste = new ToothPaste(ToothPasteBrandNames.COLGATE.name());
    }

    @Test
    void checkBagFilling() {
        //given
        Boots currentBoots = boots;
        Jeans currentJeans = jeans;
        Shampoo currentShampoo = shampoo;
        Shirt currentShirt = shirt;
        Sneakers currentSneakers = sneakers;
        ToothBrash currentToothBrash = toothBrash;
        ToothPaste currentToothPaste = toothPaste;
        //when
        Bag bag = bagFiller();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(currentBoots, bag.findItem(boots)),
                () -> Assertions.assertEquals(currentJeans, bag.findItem(jeans)),
                () -> Assertions.assertEquals(currentShampoo, bag.findItem(shampoo)),
                () -> Assertions.assertEquals(currentShirt, bag.findItem(shirt)),
                () -> Assertions.assertEquals(currentSneakers, bag.findItem(sneakers)),
                () -> Assertions.assertEquals(currentToothBrash, bag.findItem(toothBrash)),
                () -> Assertions.assertEquals(currentToothPaste, bag.findItem(toothPaste))
        );
    }

    @Test
    void checkItemFromBagRemoving() {
        //given
        Bag bag = bagFiller();
        //when
        bag.removeFromBag(boots);
        bag.removeFromBag(jeans);
        bag.removeFromBag(shampoo);
        bag.removeFromBag(shirt);
        bag.removeFromBag(sneakers);
        bag.removeFromBag(toothBrash);
        bag.removeFromBag(toothPaste);
        //then
        Assertions.assertEquals(0, bag.getBagSize());
    }

    @Test
    void checkBagClearing() {
        //given
        Bag bag = bagFiller();
        //when
        bag.clearBag();
        //then
        Assertions.assertEquals(0, bag.getBagSize());
    }

    private Bag bagFiller() {
        Bag bag = new Bag();
        bag.addIntoBag(boots);
        bag.addIntoBag(jeans);
        bag.addIntoBag(shampoo);
        bag.addIntoBag(shirt);
        bag.addIntoBag(sneakers);
        bag.addIntoBag(toothBrash);
        bag.addIntoBag(toothPaste);
        return bag;
    }


}
