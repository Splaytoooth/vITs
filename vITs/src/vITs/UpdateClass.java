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
public class UpdateClass {
    
    public static void main(String[] argv) {
        try {
                Connection connection = DatabasTest.newConnection();
                        
                Statement myStmt = connection.createStatement();
                
               // String sql = "Insert into Reseforskott values ('" + rf.getText() + "','" + rf.getSumma() + "';'" + rf.getValuta() + "')";
                
                //myStmt.executeUpdate(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } 
    }
    
    public static void insertReseforskott(EntityGrej.Reseförskott rf) {
        try {
                //Connection connection = DriverManager.getConnection("jdbc:mysql://resadb.cnjxqasdqhys.us-west-2.rds.amazonaws.com:3306/resaDB", "resaDB", "resaDB1234");
            Connection connection = DatabasTest.newConnection();
            
                Statement myStmt = connection.createStatement();
                //public Reseförskott(int id, String motivering, int summa, boolean accepterat)
                String sql = "Insert into Reseförskott(Motivering, Summa, KonsultID, ReseutläggsID, Accepterat) values ('" + rf.getMotivering() + "'," + rf.getSumma() + ", " + rf.getKonsultID() + ", null, null)";
                
                myStmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Ärende skickat!");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se);
        }
    }
}
