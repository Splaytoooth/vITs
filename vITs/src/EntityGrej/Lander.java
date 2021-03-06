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
 * @author Matus
 */
@Entity
@Table(name = "Lander")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lander.findAll", query = "SELECT l FROM Lander l"),
    @NamedQuery(name = "Lander.findByLand", query = "SELECT l FROM Lander l WHERE l.land = :land")})
public class Lander implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Land")
    private String land;

    public Lander() {
    }

    public Lander(String land) {
        this.land = land;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (land != null ? land.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lander)) {
            return false;
        }
        Lander other = (Lander) object;
        if ((this.land == null && other.land != null) || (this.land != null && !this.land.equals(other.land))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityGrej.Lander[ land=" + land + " ]";
    }
    
}
