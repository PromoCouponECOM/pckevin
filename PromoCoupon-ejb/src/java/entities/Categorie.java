/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John624
 */
@Entity
@Table(name = "Categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByIdCateg", query = "SELECT c FROM Categorie c WHERE c.idCateg = :idCateg"),
    @NamedQuery(name = "Categorie.findByNomCateg", query = "SELECT c FROM Categorie c WHERE c.nomCateg = :nomCateg"),
    @NamedQuery(name = "Categorie.findByDateModif", query = "SELECT c FROM Categorie c WHERE c.dateModif = :dateModif")})
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCateg")
    private Short idCateg;
    @Size(max = 20)
    @Column(name = "nomCateg")
    private String nomCateg;
    @Column(name = "dateModif")
    @Temporal(TemporalType.DATE)
    private Date dateModif;
    @OneToMany(mappedBy = "categorie")
    private Collection<Offre> offreCollection;

    public Categorie() {
    }

    public Categorie(Short idCateg) {
        this.idCateg = idCateg;
    }

    public Short getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Short idCateg) {
        this.idCateg = idCateg;
    }

    public String getNomCateg() {
        return nomCateg;
    }

    public void setNomCateg(String nomCateg) {
        this.nomCateg = nomCateg;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    @XmlTransient
    public Collection<Offre> getOffreCollection() {
        return offreCollection;
    }

    public void setOffreCollection(Collection<Offre> offreCollection) {
        this.offreCollection = offreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCateg != null ? idCateg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idCateg == null && other.idCateg != null) || (this.idCateg != null && !this.idCateg.equals(other.idCateg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categorie[ idCateg=" + idCateg + " ]";
    }
    
}
