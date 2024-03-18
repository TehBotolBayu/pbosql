package com.praktikum;
import java.sql.*; 

public class DB {
    Connection con;
    public DB() {
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/sonoo","root","");  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }
}
