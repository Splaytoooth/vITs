/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGrej;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 93stealb
 */
public class UtgiftExpTabell {

    public String Typ;
    public Double KostnadExklMoms;
    public Double KostnadInklMoms;
    public Double Mil;
    public Double valutaKonv;
    public Date Datum;
    public String nDagar;
    public String KvittoUrl;
    public String Valuta;
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

    public UtgiftExpTabell(String typ, Double kostnadEx, Double kostnadInk, Double valutaKonv, Double mil, Date datum, String nDagar, String kvittoUrl,String valuta) {
        this.Typ = typ;
        this.KostnadInklMoms = kostnadInk;
        this.KostnadExklMoms = kostnadEx;
        this.Mil = mil;
        this.Datum = datum;
        this.nDagar = nDagar;
        this.KvittoUrl = kvittoUrl;
        this.valutaKonv = valutaKonv;
        this.Valuta = valuta;
    }

    public UtgiftExpTabell() {
    }
}
