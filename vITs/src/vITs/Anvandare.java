package vITs;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramme
 */
public class Anvandare {

    public static void nyAnvandare(String anvandarnamn, String losenord, String fornamn, String efternamn, String email, int id) {
        Connection conn = DatabasTest.newConnection();

        try {
            Statement myStmt = conn.createStatement();
            String sql = "insert into Konsulter (Email, Anvandarnamn, Losenord, Fornamn, Efternamn, ChefID) values ('" + email + "', '" + anvandarnamn + "', '" + losenord + "', '" + fornamn + "', '" + efternamn + "', " + id + ")";

            myStmt.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel, var god försök igen");
        }

    }

}
