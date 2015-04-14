package EntityGrej;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Matus
 */
@Entity
@Table(name = "Reseutl\u00e4gg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reseutl\u00e4gg.findAll", query = "SELECT r FROM Reseutl\u00e4gg r"),
    @NamedQuery(name = "Reseutl\u00e4gg.findById", query = "SELECT r FROM Reseutl\u00e4gg r WHERE r.id = :id"),
    @NamedQuery(name = "Reseutl\u00e4gg.findByStartDatum", query = "SELECT r FROM Reseutl\u00e4gg r WHERE r.startDatum = :startDatum"),
    @NamedQuery(name = "Reseutl\u00e4gg.findBySlutDatum", query = "SELECT r FROM Reseutl\u00e4gg r WHERE r.slutDatum = :slutDatum"),
    @NamedQuery(name = "Reseutl\u00e4gg.findByFranLand", query = "SELECT r FROM Reseutl\u00e4gg r WHERE r.franLand = :franLand"),
    @NamedQuery(name = "Reseutl\u00e4gg.findByTillLand", query = "SELECT r FROM Reseutl\u00e4gg r WHERE r.tillLand = :tillLand"),
    @NamedQuery(name = "Reseutl\u00e4gg.findByAccepterat", query = "SELECT r FROM Reseutl\u00e4gg r WHERE r.accepterat = :accepterat")})
public class Reseutlägg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "StartDatum")
    @Temporal(TemporalType.DATE)
    private String startDatum;
    @Basic(optional = false)
    @Column(name = "SlutDatum")
    @Temporal(TemporalType.DATE)
    private String slutDatum;
    @Basic(optional = false)
    @Column(name = "FranLand")
    private String franLand;
    @Basic(optional = false)
    @Column(name = "TillLand")
    private String tillLand;
    @Basic(optional = false)
    @Column(name = "Accepterat")
    private boolean accepterat;
    @OneToMany(mappedBy = "reseutl\u00e4ggsID")
    private Collection<Reseförskott> reseförskottCollection;

    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

    public Reseutlägg() {
    }

    public Reseutlägg(Integer id) {
        this.id = id;
    }

    public Reseutlägg(Integer id, Date startDatum, Date slutDatum, String franLand, String tillLand, boolean accepterat) {
        this.id = id;
        this.startDatum = f.format(startDatum);;
        this.slutDatum = f.format(slutDatum);;
        this.franLand = franLand;
        this.tillLand = tillLand;
        this.accepterat = accepterat;
    }

    public void sparaIUtkast() {
        try {
            File file = new File("Hejhej.txt");
            PrintWriter out = new PrintWriter(file);

            //String reseutlägg = ""
            out.write("dsads");
            out.close();
        } catch (FileNotFoundException hej) {
            System.out.println(hej);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = f.format(startDatum);
    }

    public String getSlutDatum() {
        return slutDatum;
    }

    public void setSlutDatum(Date slutDatum) {
        this.slutDatum = f.format(slutDatum);
    }

    public String getFranLand() {
        return franLand;
    }

    public void setFranLand(String franLand) {
        this.franLand = franLand;
    }

    public String getTillLand() {
        return tillLand;
    }

    public void setTillLand(String tillLand) {
        this.tillLand = tillLand;
    }

    public boolean getAccepterat() {
        return accepterat;
    }

    public void setAccepterat(boolean accepterat) {
        this.accepterat = accepterat;
    }

    @XmlTransient
    public Collection<Reseförskott> getReseförskottCollection() {
        return reseförskottCollection;
    }

    public void setReseförskottCollection(Collection<Reseförskott> reseförskottCollection) {
        this.reseförskottCollection = reseförskottCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reseutlägg)) {
            return false;
        }
        Reseutlägg other = (Reseutlägg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityGrej.Reseutl\u00e4gg[ id=" + id + " ]";
    }

}
