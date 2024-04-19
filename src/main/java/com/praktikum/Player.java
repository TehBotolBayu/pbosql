package com.praktikum;

public class Player extends Human{

    public Player(int id, String name, int age, String position) {
        super(id, name, age, position);
    }

    @Override
    public void printData() {
        System.out.println("Player{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", position='" + super.getPosition() + '\'' +
                '}');
    }

    @Override
    public void death(){
        System.out.println("anda telah kalah");
    }
}
