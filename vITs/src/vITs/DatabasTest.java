/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vITs;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Matus
 */
public class DatabasTest {

    public static void main(String[] argv) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://resadb.cnjxqasdqhys.us-west-2.rds.amazonaws.com:3306/resaDB", "resaDB", "resaDB1234");

            Statement myStmt = connection.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from Konsulter");

            while (myRs.next()) {
                System.out.println(myRs.getString("Email"));
            }
        } catch (SQLException e) {
            System.out.print("Det blev fel");
            e.printStackTrace();
            return;
        }
    }

    public static Connection newConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://resadb.cnjxqasdqhys.us-west-2.rds.amazonaws.com:3306/resaDB", "resaDB", "resaDB1234");
            return connection;
        } catch (SQLException e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Misslyckades att koppla upp till databasen");
            return null;
        }
    }
    
    public static String getChefMail(int ID) {
        int ettChefID = 0;
        System.out.print("select ChefID from Konsulter where ID =" + ID);
        try {
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();

            ResultSet myRs = myStmt.executeQuery("select ChefID from Konsulter where ID =" + ID);

            myRs.next();
            ettChefID = myRs.getInt("ChefID");
            
        } catch (SQLException e) {
            System.out.print("Det blev fel");
            e.printStackTrace();
        }
        
        String enChefMail = "";
        System.out.print("select Email from Konsulter where ChefID=" + ettChefID);
        try { 
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();

            ResultSet myRs = myStmt.executeQuery("select Email from Konsulter where ID=" + ettChefID);
            
            myRs.next();
            enChefMail = myRs.getString("Email");
            
        } catch (SQLException e) {
            System.out.print("Det blev fel");
            e.printStackTrace();
        }
         
        return enChefMail; 
    }
    
    public static String getMail(int Id) {
        String enMail = "";
        try { 
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();

            ResultSet myRs = myStmt.executeQuery("select Email from Konsulter where ID=" + Id);
            
            myRs.next();
            enMail = myRs.getString("Email");
        } catch (SQLException e) {
            System.out.print("Det blev fel");
            e.printStackTrace();
        }
         
        return enMail;
    }
    
    public static ResultSet getTable(String query)
    {
        ResultSet myRs = null;
        try{
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();
            
            myRs = myStmt.executeQuery(query);
        }
        catch(SQLException e){
        System.out.println(e);
        }
        return myRs;
    }
    
    public static String getKonsultIdFromArende(String arandeId, String arande) {
        String ettId = ""; 
        try { 
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();

            ResultSet myRs = myStmt.executeQuery("select KonsultID from " + arande + " where ID = " + arandeId);
            
            myRs.next();
            ettId= myRs.getString("KonsultID");
        } catch (SQLException e) {
            System.out.print("Det blev fel");
            e.printStackTrace();
        }
        return ettId;
    }

}
