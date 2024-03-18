package com.praktikum;

public class Player {
    private int id;
    private String name;
    private int age;
    private String position;

    public Player(int id, String name, int age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // Getters and setters for the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Optional: Override toString() method for debugging or logging purposes
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}
