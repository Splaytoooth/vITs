
package Validering;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;





public class Valid {
    
    
    
    
    
    
    
    
       // metoden kollar om ett inmatningsfält enbart innehåller siffror och bindestreck
    static public boolean onlyNumbers(JTextField tf) {
        if (!tf.getText().matches("[\\s[0-9-]]+")) {  // hanterar siffrorna 0-9, bindestreck, samt whitespace, och via + flera återkommande sådana element
            JOptionPane.showMessageDialog(null, "Fältet stödjer enbart siffror ");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }
    
    
      // metoden kollar om innehållet i ett textfält är tomt
    static public boolean noText(JTextField tf) {
        if (tf.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Samtliga fält måste vara ifyllda");
            return true;
        } else {
            return false;

        }
    }

    // metoden kollar om innehållet i en textarea är tomt
    static public boolean noTextInArea(JTextArea ta) {
        if (ta.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Samtliga fält måste vara ifyllda");
            return true;
        } else {
            return false;

        }
    }
    
    // kolla så att email-fältet inkl @
    static public boolean emailIncludesAtAndDot(JTextField tf) {
        if (!(tf.getText().contains("@")) && !(tf.getText().contains("."))) {
            JOptionPane.showMessageDialog(null, "Email-fältet måste inkludera @ och .");
            tf.requestFocus();
            return true;
        } else {

            return false;

        }

    }
    
    
      // metoden är specifik för inmatning av användarnamn
    // Ett anv.namn får enligt databasen ej bestå utav fler än 6 chars
    // Vilket denna metod kollar upp
    static public boolean restrictMotiveringLength (JTextField tf) {
        if (tf.getText().length() < 20) {
            JOptionPane.showMessageDialog(null, "Du måste ange en fullständig motivering på minst 20 tecken");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }
    
    
    
   // metoden är specifik för inmatning av användarnamn
    // Ett anv.namn får enligt databasen ej bestå utav fler än 6 chars
    // Vilket denna metod kollar upp
    static public boolean restrictLength (JTextField tf) {
        if (tf.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Du får ej mata in fler än 10 symboler i detta fält");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }
    
    
}
