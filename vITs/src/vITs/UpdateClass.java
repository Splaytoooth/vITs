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

    public static void insertReseutlägg(EntityGrej.Reseutlägg ru, EntityGrej.UtgiftExpTabell[] utgifter, int konsultID) {
        try {
            Connection conn = DatabasTest.newConnection();

            Statement myStmt = conn.createStatement();

            String sql = "Select ID from Reseutlägg\n"
                    + "ORDER BY ID desc\n"
                    + "LIMIT 1";

            ResultSet rs = myStmt.executeQuery(sql);
            rs.next();
            int id = Integer.parseInt(rs.getString(1)) + 1;

            sql = "insert into Reseutlägg(ID, KonsultID, StartDatum, SlutDatum, FranLand, TillLand, Accepterat) VALUES(" + id + ", " + konsultID + ", '" + ru.getStartDatum() + "', '" + ru.getSlutDatum() + "', '" + ru.getFranLand() + "', '" + ru.getTillLand() + "', null)";

            myStmt.executeUpdate(sql);

            for (EntityGrej.UtgiftExpTabell utg : utgifter) {
                sql = "INSERT INTO Utgifter(Typ, ReseUtlaggsID, `Summa ink moms`, `Summa exl moms`)VALUES('"
                        + utg.Typ + "', " + id + ", '" + utg.KostnadInklMoms + "', '" + utg.KostnadExklMoms + "')";
                myStmt.executeUpdate(sql);
            }

            JOptionPane.showMessageDialog(null, "Ärende skickat!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void accepteraUtbetalning(String Id, String table) {
        try {
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();

            String sql = "update " + table + " set Accepterat = 1 where ID = " + Id;

            myStmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Ärende accepterat!");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se);
        }
    }

    public static void accepteraInteUtbetalning(String Id, String table) {
        try {
            Connection connection = DatabasTest.newConnection();

            Statement myStmt = connection.createStatement();

            String sql = "update " + table + " set Accepterat = 0 where ID = " + Id;

            myStmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Ärendet ej accepterat!");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se);
        }
    }
}
