/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGrej;

/**
 *
 * @author 93stealb
 */
public class UtgiftExpTabell {

    public String Typ;
    public String KostnadExklMoms;
    public String KostandInklMoms;
    public String Mil;
    public String Datum;
    public String nDagar;
    public String KvittoUrl;
    public UtgiftExpTabell(String typ, String kostnadEx, String kostnadInk, String mil, String datum, String nDagar, String kvittoUrl) 
    {
        this.Typ = typ;
        this.KostandInklMoms = kostnadInk;
        this.KostnadExklMoms = kostnadEx;
        this.Mil = mil;
        this.Datum = datum;
        this.nDagar = nDagar;
        this.KvittoUrl = kvittoUrl;
    }
}
