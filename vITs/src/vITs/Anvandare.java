package vITs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramme
 */
public class Anvandare {

    public static boolean nyAnvandare(String anvandarnamn, String losenord, String fornamn, String efternamn, String email, int id) {
        Connection conn = DatabasTest.newConnection();

        try {
            Statement myStmt = conn.createStatement();
            String sql = "insert into Konsulter (Email, Anvandarnamn, Losenord, Fornamn, Efternamn, ChefID) values ('" + email + "', '" + anvandarnamn + "', '" + losenord + "', '" + fornamn + "', '" + efternamn + "', " + id + ")";

            myStmt.executeUpdate(sql);
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Det användarnamnet är upptaget");
            return false;
        }

    }

    public static ResultSet hamtaAnstallda(int id) {

        Connection conn = DatabasTest.newConnection();

        try {
            Statement myStmt = conn.createStatement();
            String sql = "select * from Konsulter where ChefID=" + id;

            return myStmt.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel, var god försök igen");
            return null;
        }
    }

    public static void raderaAnvandare(int id) {
         Connection conn = DatabasTest.newConnection();

        try {
            Statement myStmt = conn.createStatement();
            String sql = "Delete from Konsulter where id="+ id;

            myStmt.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel, var god försök igen");
        }
    }

}
