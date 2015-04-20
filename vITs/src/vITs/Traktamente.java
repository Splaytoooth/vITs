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

    public EntityGrej.TraktamenteBil bil;
    public EntityGrej.TraktamenteMatSverige[] matSverige = new EntityGrej.TraktamenteMatSverige[3];
    public EntityGrej.TraktamenteMatUtomlands[] matUtomlands = new EntityGrej.TraktamenteMatUtomlands[3];
    public Double franLandNormalBelopp;
    public Double tillLandNormalBelopp;
    public String franLand;
    public String tillLand;
    public EntityGrej.Valutor[] valutor;

    public Traktamente(String franLand, String tillLand) {
        Connection conn = DatabasTest.newConnection();
        try {
            Statement myStmt = conn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from TraktamenteBil");
            while (myRs.next()) {
                bil.setTyp(myRs.getString(1));
                bil.setAvdrag(Double.parseDouble(myRs.getString(2)));
            }

            myRs = myStmt.executeQuery("select * from TraktamenteMatSverige");
            int i = 0;
            while (myRs.next()) {
                EntityGrej.TraktamenteMatSverige traktSv = new EntityGrej.TraktamenteMatSverige();
                traktSv.setTyp(myRs.getString(1));
                traktSv.setAvdragsProcent(Integer.parseInt(myRs.getString(2)));
                matSverige[i] = traktSv;
                i++;
            }
            i = 0;
            myRs = myStmt.executeQuery("select * from TraktamenteMatUtomlands");
            while (myRs.next()) {

                EntityGrej.TraktamenteMatUtomlands traktUt = new EntityGrej.TraktamenteMatUtomlands();
                traktUt.setTyp(myRs.getString(1));
                traktUt.setAvdragsProcent(Integer.parseInt(myRs.getString(2)));
                matUtomlands[i] = traktUt;
                i++;
            }

            myRs = myStmt.executeQuery("select Maxbelopp from Lander where Land = '" + tillLand + "'");
            myRs.next();
            tillLandNormalBelopp = Double.parseDouble(myRs.getString(1));

            myRs = myStmt.executeQuery("select Maxbelopp from Lander where Land = '" + franLand + "'");
            myRs.next();
            franLandNormalBelopp = Double.parseDouble(myRs.getString(1));

            myRs = myStmt.executeQuery("select * from Valutor");
            EntityGrej.Valutor aktValuta = new EntityGrej.Valutor();
            int rowcount = 0;
            if (myRs.last()) {
                rowcount = myRs.getRow();
                myRs.beforeFirst();
            }

            valutor = new EntityGrej.Valutor[rowcount];
            while (myRs.next()) {
                aktValuta.setValuta(myRs.getString(1));
                aktValuta.setKronor(Double.parseDouble(myRs.getString(2)));
                valutor[myRs.getRow()] = aktValuta;
            }

            this.franLand = franLand;
            this.tillLand = tillLand;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
