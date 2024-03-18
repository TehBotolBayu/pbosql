package com.praktikum;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.sql.SQLException;

 class Mahasiswa {
    public String nim;
    public String nama;
    public int umur;

    public Mahasiswa(String nim, String nama, int umur) {
        this.nim = nim;
        this.nama = nama;
        this.umur = umur;
    }

    public void sapa() {
        System.out.println("Hai");
    }

    public int satu() {
        return 1;
    }
}

public class Main {

    static void add(PlayerController controller) throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(input);

        int id, age; String name, position;
        // System.out.print("Masukkan id: ");
        // id  = Integer.parseInt(read.readLine());
        System.out.print("Masukkan nama: ");
        name = read.readLine();
        System.out.print("Masukkan umur: ");
        age = Integer.parseInt(read.readLine());
        System.out.print("Masukkan posisi: ");
        position = read.readLine();

        Player P = new Player(0, name, age, position);
        try {
            controller.createPlayer(P);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void get(PlayerController controller){
        try{
            List<Player> players = controller.getAllPlayers();
            for(int i=0; i<players.size(); i++){
                System.out.println(players.get(i).getId());
                System.out.print("Name: ");
                System.out.println(players.get(i).getName());
                System.out.print("Age: ");
                System.out.println(players.get(i).getAge());
                System.out.print("Position: ");
                System.out.println(players.get(i).getPosition());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void update(){

    }

    static void delete(){

    }

    public static void main(String[] args) throws IOException{
        DB con = new DB();
        PlayerController controller = new PlayerController(con.con);
        int menu;
        Boolean jalan = true;
        while(jalan){
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");

            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader read = new BufferedReader(input);

            menu = Integer.parseInt(read.readLine());
            
            switch (menu) {
                case 1:
                    add(controller);
                    break;
                case 2:
                    get(controller);
                    break;
                default:
                    jalan = false;
                    break;
            }
        }
    }
}