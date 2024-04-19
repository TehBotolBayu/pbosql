package com.praktikum;

abstract class Shape {
    // Attribute
    // protected String color;

    // // Constructor
    // public Shape(String color) {
    //     this.color = color;
    // }

    // // Abstract methods
    // public abstract double area();
    // public abstract double perimeter();

    // // Concrete method
    // public void setColor(String color) {
    //     this.color = color;
    // }

    private String nama;

    public Shape(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}