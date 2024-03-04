package org.example.compositePattern;

public class Sneakers implements Item{

    private String brandName;

    private int size;

    public Sneakers(String brandName, int size) {
        this.brandName = brandName;
        this.size = size;
    }

    @Override
    public void presentItem() {
        System.out.println(this.brandName + " sneakers, size " + this.size);
    }

    public String getBrandName() {
        return brandName;
    }

    public int getSize() {
        return size;
    }
}
