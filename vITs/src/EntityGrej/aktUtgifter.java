/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGrej;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 93stealb
 */
public class aktUtgifter {

    private UtgiftExpTabell[] rawUtgifter;
    private Utgifter[] beraknadeUtgifter;
    private double valutaKonv;
    private double normalBelopp;

    private void newAktUtgifter(UtgiftExpTabell[] utgifter, double valutaKonv, double normalBelopp) {
        if (this.rawUtgifter == utgifter && this.valutaKonv == valutaKonv && this.normalBelopp == normalBelopp) {
            return;
        } else {
            rawUtgifter = utgifter;
            this.valutaKonv = valutaKonv;
            this.normalBelopp = normalBelopp;

            int intBjuden = 0;
            int intBil = 0;
            int intAnnat = 0;

            UtgiftExpTabell[] bjuden;
            UtgiftExpTabell[] bil;
            UtgiftExpTabell[] Annat;

            for (UtgiftExpTabell aktObj : rawUtgifter) {
                if (aktObj.Typ.equals("Bjuden på frukost") || aktObj.Typ.equals("Bjuden på lunch") || aktObj.Typ.equals("Bjuden på middag")) {
                    intBjuden++;
                } else if (aktObj.equals("Egen bil") || aktObj.equals("Tjänstebil med diesel") || aktObj.equals("Tjänstemedel annat drivmedel")) {
                    intBil++;
                } else {
                    intAnnat++;
                }
            }
            bil = new UtgiftExpTabell[intBil];
            Annat = new UtgiftExpTabell[intAnnat];
            bjuden = new UtgiftExpTabell[intBjuden];
            intBil = 0;
            intAnnat = 0;
            intBjuden = 0;
            for (UtgiftExpTabell aktObj : rawUtgifter) {
                if (aktObj.Typ.equals("Bjuden på frukost") || aktObj.Typ.equals("Bjuden på lunch") || aktObj.Typ.equals("Bjuden på middag")) {
                    bjuden[intBjuden] = aktObj;
                    intBjuden++;
                } else if (aktObj.equals("Egen bil") || aktObj.equals("Tjänstebil med diesel") || aktObj.equals("Tjänstemedel annat drivmedel")) {
                    bil[intBil] = aktObj;
                    intBil++;
                } else {
                    Annat[intAnnat] = aktObj;
                    intAnnat++;
                }
            }

            UtgiftExpTabell[] bjudenDag = new UtgiftExpTabell[3];
            Map bjud = new HashMap();
            int i = 0;
            while (i < bjuden.length) {
                bjud.put(i, bjuden[i]);
            }
            Multimap<> mMap = new Multimap();

        }
    }
}
