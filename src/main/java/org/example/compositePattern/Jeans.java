package org.example.compositePattern;

public class Jeans implements Item{

    private String brandName;
    private int size;

    public Jeans(String brandName, int size) {
        this.brandName = brandName;
        this.size = size;
    }

    @Override
    public void presentItem() {
        System.out.println("Jeans " + this.brandName + ", size " + this.size);
    }

    public String getBrandName() {
        return brandName;
    }

    public int getSize() {
        return size;
    }
}
