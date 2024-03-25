package com.praktikum;

public class Monster {
    protected int id;
    protected String nama;
    protected int HP;

    public Monster(int id, String nama, int hP) {
        this.id = id;
        this.nama = nama;
        HP = hP;
    }

    protected void suara(){
        System.out.println("Halo");
    }

    protected void suara(String jurus){
        System.out.println("Halo, "+jurus);
    }    
}
