package org.example.compositePattern;

public class Shirt implements Item{

    private String brandName;

    private int size;

    public Shirt(String brandName, int size) {
        this.brandName = brandName;
        this.size = size;
    }

    @Override
    public void presentItem() {
        System.out.println(this.brandName + " shirt, size " + this.size);
    }

    public String getBrandName() {
        return brandName;
    }

    public int getSize() {
        return size;
    }
}
