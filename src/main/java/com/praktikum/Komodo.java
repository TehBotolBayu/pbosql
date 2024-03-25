package com.praktikum;

public class Komodo extends Monster {
    private String warnaKulit;
    private String pangkat;

    public Komodo(int id, String nama, int HP, String warnaKulit, String pangkat){
        super(id, nama, HP);
        this.warnaKulit = warnaKulit;
        this.pangkat = pangkat;
    }

    // protected void suara(){
    //     System.out.println("Sssstt...");
    // }
}
