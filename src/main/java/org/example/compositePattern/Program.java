package org.example.compositePattern;

public class Program {
    public static void main(String[] args) {
        Bag bigBag = new Bag();
        Bag shoesBag = new Bag();
        Bag washingItemsBag = new Bag();

        Boots blackBoots = new Boots("official", 43);
        Boots whiteBoots = new Boots("street", 43);
        Sneakers sneakers = new Sneakers("Nike", 43);

        Jeans blueJeans = new Jeans("Wrangler", 52);
        Shirt brownShirt = new Shirt("CK", 54);

        Shampoo shampoo = new Shampoo("Axe");
        ToothBrash toothBrash = new ToothBrash("Colgate");
        ToothPaste toothPaste = new ToothPaste("President");

        shoesBag.addIntoBag(blackBoots);
        shoesBag.addIntoBag(whiteBoots);
        shoesBag.addIntoBag(sneakers);

        washingItemsBag.addIntoBag(shampoo);
        washingItemsBag.addIntoBag(toothBrash);
        washingItemsBag.addIntoBag(toothPaste);

        bigBag.addIntoBag(shoesBag);
        bigBag.addIntoBag(washingItemsBag);
        bigBag.addIntoBag(blueJeans);
        bigBag.addIntoBag(brownShirt);

        bigBag.presentItem();

        bigBag.removeFromBag(washingItemsBag);
        bigBag.removeFromBag(brownShirt);
        shoesBag.removeFromBag(whiteBoots);

        bigBag.presentItem();

    }
}
