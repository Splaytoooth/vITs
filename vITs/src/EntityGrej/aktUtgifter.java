/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGrej;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author 93stealb
 */
public class aktUtgifter {

    private UtgiftExpTabell[] rawUtgifter;
    private List beraknadeUtgifter;
    private double valutaKonv;
    private double normalBelopp;
    private vITs.Traktamente traktamente;
    private String startDatum;
    private int dagar;

    private void newAktUtgifter(UtgiftExpTabell[] utgifter, double valutaKonv, double normalBelopp, vITs.Traktamente trakt, String startDatum, int dagar) {
        if (this.rawUtgifter == utgifter && this.valutaKonv == valutaKonv && this.normalBelopp == normalBelopp && startDatum.equals(this.startDatum) && dagar == this.dagar) {
            return;
        } else {
            rawUtgifter = utgifter;
            this.valutaKonv = valutaKonv;
            this.normalBelopp = normalBelopp;
            this.traktamente = trakt;
            beraknadeUtgifter = new ArrayList();
            this.dagar = dagar;

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
            
            

            Map<String, List<UtgiftExpTabell>> sortBjud = new HashMap<String, List<UtgiftExpTabell>>();
            for (UtgiftExpTabell aktObj : rawUtgifter) {
                if (aktObj.Typ.equals("frukost") || aktObj.Typ.equals("middag") || aktObj.Typ.equals("lunch")) {
                } else {
                    List<UtgiftExpTabell> bjudLista = new ArrayList<UtgiftExpTabell>();
                    UtgiftExpTabell[] bjudenDag = new UtgiftExpTabell[3];
                    for (UtgiftExpTabell aktObj2 : rawUtgifter) {
                        if (aktObj.Datum.equals(aktObj2.Datum)) {
                            if (aktObj2.Typ.equals("Bjuden på frukost")) {
                                aktObj2.Typ = "frukost";
                            } else if (aktObj.Typ.equals("Bjuden på lunch")) {
                                aktObj2.Typ = "lunch";
                            } else if (aktObj.Typ.equals("Bjuden på middag")) {
                                aktObj2.Typ = "middag";
                            }
                            bjudLista.add(aktObj2);
                        }
                        sortBjud.put(aktObj.Datum, bjudLista);
                    }
                }
            }

            UtgiftExpTabell utgStartDag = new UtgiftExpTabell(null, null, null, null, null, null, null);
            utgStartDag.Typ = "Första dagen i " + traktamente.franLand;
            utgStartDag.KostnadInklMoms = traktamente.franLandNormalBelopp * valutaKonv;
            utgStartDag.KostnadExklMoms = traktamente.franLandNormalBelopp * valutaKonv;
            beraknadeUtgifter.add(utgStartDag);

            UtgiftExpTabell utgRestDagar = new UtgiftExpTabell(null, null, null, null, null, null, null);
            utgRestDagar.Typ = dagar + "dagar i " + traktamente.tillLand;
            utgRestDagar.KostnadExklMoms = traktamente.tillLandNormalBelopp * dagar * valutaKonv;
            utgRestDagar.KostnadInklMoms = traktamente.tillLandNormalBelopp * dagar * valutaKonv;

            for (Entry<String, List<UtgiftExpTabell>> entry : sortBjud.entrySet()) {
                String key = entry.getKey();
                List<UtgiftExpTabell> aktLista = entry.getValue();
                UtgiftExpTabell nyUtg = new UtgiftExpTabell(null, null, null, null, null, null, null);
                nyUtg.Datum = aktLista.get(0).Datum;
                boolean forstDag = false;
                if (aktLista.get(0).Datum.equals(startDatum)) {
                    forstDag = true;
                }
                double procent = 0;
                String utgTyp = "Bjuden på ";
                for (UtgiftExpTabell utgift : aktLista) {
                    utgTyp += utgift.Typ + ", ";
                    if (utgift.Typ.equals("frukost")) {
                        if (forstDag == true && traktamente.franLand.equals("Sverige")) {
                            procent += traktamente.matSverige[0].getAvdragsProcent();
                        } else {
                            procent += traktamente.matUtomlands[0].getAvdragsProcent();
                        }
                    } else if (utgift.Typ.equals("lunch")) {
                        if (forstDag == true && traktamente.franLand.equals("Sverige")) {
                            procent += traktamente.matSverige[1].getAvdragsProcent();
                        } else {
                            procent += traktamente.matUtomlands[1].getAvdragsProcent();
                        }
                    } else if (utgift.Typ.equals("middag")) {
                        if (forstDag == true && traktamente.franLand.equals("Sverige")) {
                            procent += traktamente.matSverige[2].getAvdragsProcent();
                        } else {
                            procent += traktamente.matUtomlands[2].getAvdragsProcent();
                        }
                    }
                    utgTyp = utgTyp.substring(0, utgTyp.length() - 2);
                    utgTyp += " den " + aktLista.get(0).Datum;
                    if (forstDag == true && traktamente.franLand.equals("Sverige")) {
                        utgTyp += ", första resdagen fortfarande i " + traktamente.franLand;
                    }
                    utgift.KostnadExklMoms = traktamente.franLandNormalBelopp * valutaKonv * procent * -1;
                    utgift.KostnadInklMoms = utgift.KostnadExklMoms;
                    this.beraknadeUtgifter.add(utgift);
                }
            }
            
            

        }
    }
}
