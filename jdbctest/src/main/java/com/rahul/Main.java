package com.rahul;

import java.sql.*;
public  class Main {
    public static void main(String[]args){
        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="cdac";
        String query="Select * from person";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully...");


        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection successfully..");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String dob=rs.getString("dob");
                System.out.println();
                System.out.println("-----------------------------------------");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("dob: "+dob);

            }
            rs.close();
            stmt.close();
            con.close();

            System.out.println("connection close successfully..");


        }catch (SQLException e){
            System.out.println(e);
        }

    }
}