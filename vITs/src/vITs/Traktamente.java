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
    EntityGrej.TraktamenteMatSverige matSverige;
    EntityGrej.TraktamenteMatSverige matUtomlands;
    Double franLandNormalBelopp;
    Double tillLandNormalBelopp;
    String franLand;
    String tillLand;

    public void Traktamente(String franLand, String tillLand) {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from TraktamenteBil");
            while (myRs.next()) {
                bil.setTyp(myRs.getString(1));
                bil.setAvdrag(Double.parseDouble(myRs.getString(2)));
            }

            myRs = myStmt.executeQuery("select * from TraktamenteMatSverige");
            while (myRs.next()) {
                matSverige.setTyp(myRs.getString(1));
                matSverige.setAvdragsProcent(Integer.parseInt(myRs.getString(2)));
            }
            myRs = myStmt.executeQuery("select * from TraktamenteMatUtomlands");
            while (myRs.next()) {
                matUtomlands.setTyp(myRs.getString(1));
                matUtomlands.setAvdragsProcent(Integer.parseInt(myRs.getString(2)));
            }

            myRs = myStmt.executeQuery("select Maxbelopp from Lander where Land = '" + tillLand + "'");
            myRs.next();
            tillLandNormalBelopp = Double.parseDouble(myRs.getString(1));
            
            myRs = myStmt.executeQuery("select Maxbelopp from Lander where Land = '" + franLand + "'");
            myRs.next();
            franLandNormalBelopp = Double.parseDouble(myRs.getString(1));
            
            
            this.franLand = franLand;
            this.tillLand = tillLand;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
