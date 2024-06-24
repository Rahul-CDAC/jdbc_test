package com.rahul;

import java.sql.*;
public  class jdbcupdate {
    public static void main(String[]args){
        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="cdac";
        String query="update person set name='sharma',dob='1-1-2009' where id=11;";

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
            int rowsaffected =stmt.executeUpdate(query);
            if(rowsaffected>0){
                System.out.println("Update successful"+rowsaffected+"rows affected.");
            }else{
                System.out.println("Updation failed!!!");


            }
//            while(rs.next()){
//                int id=rs.getInt("id");
//                String name=rs.getString("name");
//                String phone=rs.getString("dob");
//                System.out.println();
//                System.out.println("-----------------------------------------");
//                System.out.println("ID: "+id);
//                System.out.println("Name: "+name);
//                System.out.println("dob": "+dob);
//
//            }
            //rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection close successfully...");


        }catch (SQLException e){
            System.out.println(e);
        }

    }
}