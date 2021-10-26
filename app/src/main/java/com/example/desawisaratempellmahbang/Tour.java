package com.example.desawisaratempellmahbang;

public class Tour {
    private String name;
    private int price;
    private final int imageResource;

    Tour(String name, int price, int imageResource){
        this.name =name;
        this.price = price;
        this.imageResource = imageResource;
    }

    String getName() { return name; }
    int getPrice() { return price; }
    int getImageResource() { return imageResource; }
}
