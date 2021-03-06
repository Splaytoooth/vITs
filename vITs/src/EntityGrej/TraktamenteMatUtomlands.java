/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGrej;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 93stealb
 */
@Entity
@Table(name = "TraktamenteMatUtomlands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TraktamenteMatUtomlands.findAll", query = "SELECT t FROM TraktamenteMatUtomlands t"),
    @NamedQuery(name = "TraktamenteMatUtomlands.findByTyp", query = "SELECT t FROM TraktamenteMatUtomlands t WHERE t.typ = :typ"),
    @NamedQuery(name = "TraktamenteMatUtomlands.findByAvdragsProcent", query = "SELECT t FROM TraktamenteMatUtomlands t WHERE t.avdragsProcent = :avdragsProcent")})
public class TraktamenteMatUtomlands implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Typ")
    private String typ;
    @Column(name = "AvdragsProcent")
    private Integer avdragsProcent;

    public TraktamenteMatUtomlands() {
    }

    public TraktamenteMatUtomlands(String typ) {
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getAvdragsProcent() {
        return avdragsProcent;
    }

    public void setAvdragsProcent(Integer avdragsProcent) {
        this.avdragsProcent = avdragsProcent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typ != null ? typ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraktamenteMatUtomlands)) {
            return false;
        }
        TraktamenteMatUtomlands other = (TraktamenteMatUtomlands) object;
        if ((this.typ == null && other.typ != null) || (this.typ != null && !this.typ.equals(other.typ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityGrej.TraktamenteMatUtomlands[ typ=" + typ + " ]";
    }
    
}
