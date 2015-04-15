package localDBbuilder;

import java.sql.*;
import javax.swing.*;

public class EmbeddedDBcreator {
    
         
     public static void main(String[] argv) {    
         try {
             String createString = "CREATE TABLE MORESTUFF3 (STUFFNAME VARCHAR(50) NOT NULL, Stuff_attribute VARCHAR(50))";
            Connection connection = DriverManager.getConnection("jdbc:derby:myDatabase;create=true");
            Statement myStmt = connection.createStatement();
            System.out.println("Db established");
            myStmt.executeUpdate(createString);
            System.out.println(createString);
            
            String insertString = "INSERT INTO MORESTUFF3 VALUES ('6', '7') ";
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
