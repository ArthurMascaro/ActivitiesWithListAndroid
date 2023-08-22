package com.example.exercise3bim.src.model;

public class Produto {

    String name;
    String brand;
    int quantity;
    boolean sold;

    public Produto(String name, String brand, int quantity, boolean sold) {
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.sold = sold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
