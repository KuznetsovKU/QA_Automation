package org.example.compositePattern;

public class Shampoo implements Item{

    private String brandName;

    public Shampoo(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public void presentItem() {
        System.out.println("Shampoo " + this.brandName);
    }

    public String getBrandName() {
        return brandName;
    }
}
