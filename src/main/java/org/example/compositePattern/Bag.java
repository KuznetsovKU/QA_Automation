package org.example.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Item{

    private List<Item> bag;

    public Bag() {
        this.bag = new ArrayList<Item>();
    }

    public void addIntoBag(Item item) {
        bag.add(item);
    }

    public void removeFromBag(Item item) {
        bag.remove(item);
    }

    public void clearBag() {
        bag.clear();
    }

    public int getBagSize() {
        return bag.size();
    }

    @Override
    public void presentItem() {
        for (Item item: bag) {
            item.presentItem();
        }
    }

    public Item findItem(Item i) {
        for (Item item : bag) {
            if (item.equals(i)) {
                return item;
            }
        }
        return null;
    }
}
