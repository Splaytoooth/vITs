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
 * @author Nils-Inge
 */
@Entity
@Table(name = "Valutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valutor.findAll", query = "SELECT v FROM Valutor v"),
    @NamedQuery(name = "Valutor.findByValuta", query = "SELECT v FROM Valutor v WHERE v.valuta = :valuta"),
    @NamedQuery(name = "Valutor.findByKronor", query = "SELECT v FROM Valutor v WHERE v.kronor = :kronor")})
public class Valutor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Valuta")
    private String valuta;
    @Basic(optional = false)
    @Column(name = "Kronor")
    private double kronor;

    public Valutor() {
    }

    public Valutor(String valuta) {
        this.valuta = valuta;
    }

    public Valutor(String valuta, double kronor) {
        this.valuta = valuta;
        this.kronor = kronor;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public double getKronor() {
        return kronor;
    }

    public void setKronor(double kronor) {
        this.kronor = kronor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valuta != null ? valuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valutor)) {
            return false;
        }
        Valutor other = (Valutor) object;
        if ((this.valuta == null && other.valuta != null) || (this.valuta != null && !this.valuta.equals(other.valuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityGrej.Valutor[ valuta=" + valuta + " ]";
    }
    
}
