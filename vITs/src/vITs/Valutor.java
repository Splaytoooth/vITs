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
 * @author 93stealb
 */
public class Valutor {

    public static ResultSet HamtaValutor() {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            String sql = "Select * from Valutor";

            return myStmt.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static void nyValuta(String namn, double kurs) {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            String sql = "Insert into Valutor values('" + namn + "', " + kurs + ")";

            myStmt.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void removeValuta(String namn) {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();
            
            String sql = "Delete from Valutor where ";
        }
        
        catch(Exception e) {}
    }
}
