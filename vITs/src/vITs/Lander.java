/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vITs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 93stealb
 */
public class Lander {

    public static ResultSet getLander() {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            String sql = "Select * from Lander";

            return myStmt.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static void nyLand(String namn, double normalBelopp) {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            String sql = "Insert into Lander values('" + namn + "', " + normalBelopp + ")";

            myStmt.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Det landet finns redan registrerat");
        }
    }

    public static void removeLand(String namn) {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            String sql = "Delete from Lander where Land = '" + namn + "'";

            myStmt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
    
     public static void updateLand(String valutaNamn, double valKonv) {
        try {
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();

            String sql = "update Lander set Maxbelopp = " + valKonv + " where Land='" + valutaNamn + "'";

            myStmt.executeUpdate(sql);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se);
        }
    }
}
