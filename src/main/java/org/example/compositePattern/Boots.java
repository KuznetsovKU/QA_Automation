package org.example.compositePattern;

public class Boots implements Item{

    private String type;

    private int size;

    public Boots(String type, int size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public void presentItem() {
        System.out.println(this.type + " boots, size " + this.size);
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
