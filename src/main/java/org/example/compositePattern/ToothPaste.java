package org.example.compositePattern;

public class ToothPaste implements Item{

    private String brandName;

    public ToothPaste(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public void presentItem() {
        System.out.println("ToothPaste " + this.brandName);
    }

    public String getBrandName() {
        return brandName;
    }
}
