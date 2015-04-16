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
public class Traktamente {

    EntityGrej.TraktamenteBil bil;
    EntityGrej.TraktamenteMat mat;
    Double normalBelopp;

    public void Traktamente(String land) {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from TraktamenteBil");
            while (myRs.next()) {
                bil.setTyp(myRs.getString(1));
                bil.setAvdrag(Double.parseDouble(myRs.getString(2)));
            }

            if (land.equals("Sverige")) {
                myRs = myStmt.executeQuery("select * from TraktamenteMatSverige");
                while (myRs.next()) {
                    mat.setTyp(myRs.getString(1));
                    mat.setAvdragsProcent(Integer.parseInt(myRs.getString(2)));
                }
            } else {
                myRs = myStmt.executeQuery("select * from TraktamenteMatUtomlands");
                while (myRs.next()) {
                    mat.setTyp(myRs.getString(1));
                    mat.setAvdragsProcent(Integer.parseInt(myRs.getString(2)));
                }
            }
            
            myRs = myStmt.executeQuery("select Maxbelopp from Lander where Land = '" + land + "'");
            myRs.next();
            normalBelopp = Double.parseDouble(myRs.getString(1));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
