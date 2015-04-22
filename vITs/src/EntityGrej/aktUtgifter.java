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
import javax.swing.JOptionPane;

/**
 *
 * @author 93stealb
 */
public class aktUtgifter {

    private UtgiftExpTabell[] rawUtgifter;
    private ArrayList<UtgiftExpTabell> beraknadeUtgifter = new ArrayList<UtgiftExpTabell>();
    private vITs.Traktamente traktamente;
    private String startDatum;
    private int dagar;

    public ArrayList<UtgiftExpTabell> beraknadeUtgifter() {
        return beraknadeUtgifter;
    }

    public void newAktUtgifter(UtgiftExpTabell[] utgifter, vITs.Traktamente trakt, String startDatum, int dagar) {
        beraknadeUtgifter.clear();
        rawUtgifter = utgifter;
        this.traktamente = trakt;
        this.dagar = dagar;

        int intBjuden = 0;
        int intBil = 0;
        int intAnnat = 0;
        int intBoende = 0;

        for (UtgiftExpTabell aktObj : rawUtgifter) {
            if (aktObj.Typ.equals("Bjuden på frukost") || aktObj.Typ.equals("Bjuden på lunch") || aktObj.Typ.equals("Bjuden på middag")) {
                intBjuden++;
            } else if (aktObj.Typ.equals("Egen bil") || aktObj.Typ.equals("Tjänstebil med diesel") || aktObj.Typ.equals("Tjänstemedel annat drivmedel")) {
                intBil++;
            } else if (aktObj.Typ.equals("Boende med kvitto") || aktObj.Typ.equals("Boende utan kvitto")) {
                intBoende++;
            } else {
                intAnnat++;
            }
        }
        UtgiftExpTabell[] bil = new UtgiftExpTabell[intBil];
        UtgiftExpTabell[] Annat = new UtgiftExpTabell[intAnnat];
        UtgiftExpTabell[] bjuden = new UtgiftExpTabell[intBjuden];
        UtgiftExpTabell[] boende = new UtgiftExpTabell[intBoende];
        intBil = 0;
        intAnnat = 0;
        intBjuden = 0;
        intBoende = 0;
        for (UtgiftExpTabell aktObj : rawUtgifter) {
            if (aktObj.Typ.equals("Bjuden på frukost") || aktObj.Typ.equals("Bjuden på lunch") || aktObj.Typ.equals("Bjuden på middag")) {
                bjuden[intBjuden] = aktObj;
                intBjuden++;
            } else if (aktObj.Typ.equals("Egen bil") || aktObj.Typ.equals("Tjänstebil med diesel") || aktObj.Typ.equals("Tjänstemedel annat drivmedel")) {
                bil[intBil] = aktObj;
                intBil++;
            } else if (aktObj.Typ.equals("Boende med kvitto") || aktObj.Typ.equals("Boende utan kvitto")) {
                boende[intBoende] = aktObj;
                intBoende++;
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
                    try {
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
                        sortBjud.put(aktObj.Datum.toString(), bjudLista);
                    } catch (Exception e) {
                    }
                }
            }
        }

        UtgiftExpTabell utgStartDag = new UtgiftExpTabell();
        utgStartDag.Typ = "Första dagen fortfarande i " + traktamente.franLand;
        utgStartDag.KostnadInklMoms = traktamente.franLandNormalBelopp;
        utgStartDag.KostnadExklMoms = traktamente.franLandNormalBelopp;
        beraknadeUtgifter.add(utgStartDag);

        UtgiftExpTabell utgRestDagar = new UtgiftExpTabell();
        utgRestDagar.Typ = dagar + "dagar i " + traktamente.tillLand;
        utgRestDagar.KostnadExklMoms = traktamente.tillLandNormalBelopp * dagar;
        utgRestDagar.KostnadInklMoms = traktamente.tillLandNormalBelopp * dagar;
        beraknadeUtgifter.add(utgRestDagar);

        for (Entry<String, List<UtgiftExpTabell>> entry : sortBjud.entrySet()) {
            String key = entry.getKey();
            List<UtgiftExpTabell> aktLista = entry.getValue();
            UtgiftExpTabell nyUtg = new UtgiftExpTabell();
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
                if (forstDag == true) {
                    utgTyp += ", första resdagen fortfarande i " + traktamente.franLand;
                }
                utgift.KostnadExklMoms = traktamente.franLandNormalBelopp * procent * -0.01;
                utgift.KostnadInklMoms = utgift.KostnadExklMoms;
                utgift.Typ = utgTyp;
                this.beraknadeUtgifter.add(utgift);
            }
        }

        for (UtgiftExpTabell utg : bil) {
            if (utg.Typ.equals("Egen bil")) {
                utg.KostnadExklMoms = utg.Mil * traktamente.bil[0].getAvdrag();
                utg.KostnadInklMoms = utg.KostnadExklMoms;
                utg.Typ = utg.Mil + "mil med egen bil";
            } else if (utg.Typ.equals("Tjänstemedel annat drivmedel")) {
                utg.KostnadExklMoms = utg.Mil * traktamente.bil[1].getAvdrag();
                utg.Typ = utg.Mil + "mil med tjänstemedel";
                utg.KostnadInklMoms = utg.KostnadExklMoms;
            } else if (utg.Typ.equals("Tjänstebil med diesel")) {
                utg.KostnadExklMoms = utg.Mil * traktamente.bil[2].getAvdrag();
                utg.Typ = utg.Mil + "mil med tjänstemedel driven på diesel";
                utg.KostnadInklMoms = utg.KostnadExklMoms;
            }
            this.beraknadeUtgifter.add(utg);
        }

        for (UtgiftExpTabell utg : boende) {
            if (utg.Typ.equals("Boende med kvitto")) {
                utg.Typ = utg.nDagar + "dagar på hotell med sparat kvitto";
                utg.KostnadExklMoms = utg.KostnadExklMoms * utg.valutaKonv;
                utg.KostnadInklMoms = utg.KostnadInklMoms * utg.valutaKonv;
                this.beraknadeUtgifter.add(utg);
            } else if (utg.Typ.equals(("Boende utan kvitto"))) {
                utg.Typ = utg.nDagar + "dagar på hotell utan kvitto";
                utg.KostnadExklMoms = Integer.parseInt(utg.nDagar) * traktamente.tillLandNormalBelopp;
                utg.KostnadInklMoms = utg.KostnadExklMoms;
                this.beraknadeUtgifter.add(utg);
            }
        }

        for (UtgiftExpTabell utg : Annat) {
            utg.Typ = "Egen utgift '" + utg.Typ + "'";
            utg.KostnadExklMoms = utg.KostnadExklMoms * utg.valutaKonv;
            utg.KostnadInklMoms = utg.KostnadInklMoms * utg.valutaKonv;
            beraknadeUtgifter.add(utg);
        }

        System.out.println(this.beraknadeUtgifter);
    }
}
