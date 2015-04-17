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
     
     /*  valutaLandTableCreator() skapar en ny inbäddad lokal databas
     /   bestående av två tabeller: valuta och lander.
     /
     */
     public static void valutaLandTableCreator ()
     {
         try {
            String createValuta = "CREATE TABLE VALUTA_local (Valuta VARCHAR(50) NOT NULL, Kronor DOUBLE)";
            String createLand   = "CREATE TABLE LAND_local   (Land VARCHAR(50) NOT NULL, Maxbelopp DOUBLE)";
            
            Connection connection = DriverManager.getConnection("jdbc:derby:localReseDBPerm;create=true");
            Statement myStmt = connection.createStatement();
            System.out.println("Db established");
            myStmt.executeUpdate(createValuta);
            myStmt.executeUpdate(createLand);
 
            // Sätter in värden för valuta
            String insertStringVal1 = "INSERT INTO VALUTA_local VALUES ('Euro', 9.36) ";
            String insertStringVal2 = "INSERT INTO VALUTA_local VALUES ('USD', 8.79) ";
            String insertStringVal3 = "INSERT INTO VALUTA_local VALUES ('Sek', 1) ";
            
            myStmt.executeUpdate(insertStringVal1);
            myStmt.executeUpdate(insertStringVal2);
            myStmt.executeUpdate(insertStringVal3);
            
            // Sätter in värden för länder
            String insertStringLand1 = "INSERT INTO Land_local VALUES ('Sverige', 220) ";
            String insertStringLand2 = "INSERT INTO Land_local VALUES ('Livland', 278) ";
            String insertStringLand3 = "INSERT INTO Land_local VALUES ('Litauen', 347) ";
            String insertStringLand4 = "INSERT INTO Land_local VALUES ('Estland', 363) ";
            String insertStringLand5 = "INSERT INTO Land_local VALUES ('Lettland', 419) ";
            String insertStringLand6 = "INSERT INTO Land_local VALUES ('USA', 552) ";
            String insertStringLand7 = "INSERT INTO Land_local VALUES ('Island', 611) ";
            String insertStringLand8 = "INSERT INTO Land_local VALUES ('Finland', 625) ";
            String insertStringLand9 = "INSERT INTO Land_local VALUES ('Storbrittanien', 680) ";
            String insertStringLand10 = "INSERT INTO Land_local VALUES ('Danmark', 873) ";
            String insertStringLand11 = "INSERT INTO Land_local VALUES ('Norge', 937) ";
            
            myStmt.executeUpdate(insertStringLand1);
            myStmt.executeUpdate(insertStringLand2);
            myStmt.executeUpdate(insertStringLand3);
            myStmt.executeUpdate(insertStringLand4);
            myStmt.executeUpdate(insertStringLand5);
            myStmt.executeUpdate(insertStringLand6);
            myStmt.executeUpdate(insertStringLand7);
            myStmt.executeUpdate(insertStringLand8);
            myStmt.executeUpdate(insertStringLand9);
            myStmt.executeUpdate(insertStringLand10);
            myStmt.executeUpdate(insertStringLand11);
            
            
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
