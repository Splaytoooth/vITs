package localDBbuilder;

import java.sql.*;
import javax.swing.*;

public class EmbeddedDBcreator {
    
         
     public static void main(String[] args) {    
         try {
             String createString = "CREATE TABLE MORESTUFF5 (STUFFNAME VARCHAR(50) NOT NULL, Stuff_attribute VARCHAR(50))";
            Connection connection = DriverManager.getConnection("jdbc:derby:myDatabase;create=true");
            Statement myStmt = connection.createStatement();
            System.out.println("Db established");
            myStmt.executeUpdate(createString);
            System.out.println(createString);
            
            String insertString = "INSERT INTO MORESTUFF5 VALUES ('6', '7') ";
            myStmt.executeUpdate(insertString);
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print("fel");
           
        }
   
     }
   
     public static void valutaLandTableCreator ()
     {
         try {
            String createValuta = "CREATE TABLE VALUTA_local (Valuta VARCHAR(50) NOT NULL, Kronor DOUBLE( ))";
            String createLand   = "CREATE TABLE LAND_local   (Land VARCHAR(50) NOT NULL, Maxbelopp DOUBLE())";
            
            Connection connection = DriverManager.getConnection("jdbc:derby:localReseDB;create=true");
            Statement myStmt = connection.createStatement();
            System.out.println("Db established");
            myStmt.executeUpdate(createValuta);
            myStmt.executeUpdate(createLand);
 
            // Sätter in värden för valuta
            String insertStringVal1 = "INSERT INTO VALUTA_local VALUES ('EURO', 9.36) ";
            String insertStringVal2 = "INSERT INTO VALUTA_local VALUES ('USD', 8.79) ";
            
            myStmt.executeUpdate(insertStringVal1);
            myStmt.executeUpdate(insertStringVal2);
            
            // Sätter in värden för länder
            String insertStringLand1 = "INSERT INTO Land_local VALUES ('Sverige', 220) ";
            String insertStringLand2 = "INSERT INTO Land_local VALUES ('Livland', 278) ";
            String insertStringLand3 = "INSERT INTO Land_local VALUES ('Livland', 278) ";
            
            
            myStmt.executeUpdate(insertString);
            
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print("fel");
           
        }
         
     }
    

    public static Connection connectDb1() {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://resadb.cnjxqasdqhys.us-west-2.rds.amazonaws.com:3306/resaDB", "resaDB", "resaDB1234");
            Statement myStmt = connection.createStatement();
            return connection;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print("fel");
            return null;
        }

    }

    public static Connection connectDb2() {

         try {

            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/thisDb", "db3", "db3");
            Statement myStmt = connection.createStatement();
            return connection;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print("fel");
            return null;
        }

    }
    
     
         
         
         
         
    
}
