package Validering;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Valid {

    // metoden kollar så att inmatningsfältet för nytt lösenord inkluderar minst en stor bokstav, en liten bokstav samt en siffra. 
    static public boolean newPassWordController(JTextField tf) {
        if (!tf.getText().matches("[0-9]") || !(tf.getText().matches("a-z")) || !(tf.getText().matches("A-Z"))) {
            JOptionPane.showMessageDialog(null, "Ett nytt lösenord måste inkludera åtminstone en siffra, en liten bokstav samt en stor bokstav");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    // metoden kollar så att inmatningsfältet för nytt lösenord inkluderar minst en stor bokstav, en liten bokstav samt en siffra. 
    static public boolean newPassWordController2(JTextField tf) {
        if (!tf.getText().matches("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$ )")) {
            JOptionPane.showMessageDialog(null, "Ett nytt lösenord måste inkludera åtminstone en siffra, en liten bokstav samt en stor bokstav");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    // metoden kollar så att inmatningsfält ej inkluderar några siffror eller andra symboler utöver bokstäver i det latinska alfabetet 
    static public boolean onlyText(JTextField tf) {
        if (!tf.getText().matches("[a-zåäöA-ZÅÄÖ]+")) {  // hanterar siffrorna 0-9, bindestreck, samt whitespace, och via + flera återkommande sådana element
            JOptionPane.showMessageDialog(null, "Fältet stödjer ej siffror ");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }

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
    static public boolean noTextOrToMuch(JTextField tf) {
        if (tf.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Samtliga fält måste vara ifyllda");
            if (tf.getText().length() > 250) {
                JOptionPane.showMessageDialog(null, "Fältet får inte innehålla mer än 255 tecken");
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean onlyDouble(JTextField tf) {
        try {
            Double.parseDouble(tf.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fältet stödjer enbart siffror ");
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

    // kolla så att email-fältet inkl @ och .
    static public boolean emailIncludesAtAndDot(JTextField tf) {
        if (!(tf.getText().contains("@")) || !(tf.getText().contains("."))) {
            JOptionPane.showMessageDialog(null, "Email-fältet måste inkludera @ och .");
            tf.requestFocus();
            return true;
        } else {

            return false;
        }
    }

    /*   Metoden ser till att längden på motiveringen
     /    ej är för kort 
     /
     */
    static public boolean restrictMotiveringLength(JTextArea ta) {
        if (ta.getText().length() < 20) {
            JOptionPane.showMessageDialog(null, "Du måste ange en fullständig motivering på minst 20 tecken");
            ta.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    /*
     /       Kontrollerar så att användaren ej matar in 
     /       för mycket text i TF
     */
    static public boolean restrictTFLength(JTextField tf) {
        if (tf.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "Du får ej mata in fler än 20 tecken i fältet");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    /* Metoden kollar så att användaren ej matar in tomma ytor i textfältet 
     /  via exempelvis space eller tab
     / Tillämpningsområden: Förnamn, efternamn, email
     */
    static public boolean noSpaces(JTextField tf) {
        if (!tf.getText().matches("[^-\\s]+")) {
            JOptionPane.showMessageDialog(null, "Du får ej mata in tomma ytor i detta fält");
            tf.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    /*
     static public boolean startsWithCapLetter (Character checkString) {
     if (Character.isUpperCase(checkString.charAt(0)) ) {
     JOptionPane.showMessageDialog(null, "Du får ej mata in tomma ytor i detta fält");
     tf.requestFocus();
     return true;
     } else {
     return false;
     }
     }
 
     */
}
