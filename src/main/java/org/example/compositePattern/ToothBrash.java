package org.example.compositePattern;

public class ToothBrash implements Item{

    private String brandName;

    public ToothBrash(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public void presentItem() {
        System.out.println("ToothBrash " + this.brandName);
    }

    public String getBrandName() {
        return brandName;
    }
}
