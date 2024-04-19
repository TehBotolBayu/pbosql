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
        while (true) {
            
        
        System.out.print("Masukkan nama: ");
        name = read.readLine();
        System.out.print("Masukkan umur: ");
        age = Integer.parseInt(read.readLine());
        System.out.print("Masukkan posisi: ");
        position = read.readLine();

        Player P = new Player(0, name, age, position);

        System.out.println("Apakah data berikut sudah benar??");
        P.printData();
        System.out.println("1. Ya/n2. Tidak");
        int pilihan = Integer.parseInt(read.readLine());
        if(pilihan == 1){
            try {
                controller.createPlayer(P);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
        }else if(pilihan == 2){
            continue;
        }
        }
    }

    static void killPlayer(PlayerController controller) throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(input);

        int id = Integer.parseInt(read.readLine());

        
        try {
            Player P = controller.getPlayerById(id);

            P.death();

            controller.updatePlayer(P);

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

    static void jurus(Monster monster) throws IOException{
        String jurus;

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(input);

        jurus = read.readLine();

        monster.suara(jurus);

    }

    public static void main(String[] args) throws IOException{
        Monster bayu = 
        new Monster(2, "bayu", 100);

        Komodo tito = 
        new Komodo(12, "tito", 120, "abuabu", "jendrama2l");

        DB con = new DB();
        PlayerController controller = new PlayerController(con.con);
        int menu;
        Boolean jalan = true;
        while(jalan){
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Komodo bersuara");
            System.out.println("4. Monster bersuara");
            System.out.println("5. Monster ngeluarin jurus");
            System.out.println("6. Meninggal");

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
                case 3:
                    tito.suara();
                    break;
                case 4:
                    bayu.suara();
                    break;
                case 5:
                    jurus(bayu);
                    break;
                case 6:
                    killPlayer(controller);
                    break;
                default:
                    jalan = false;
                    break;
            }
        }
    }
}