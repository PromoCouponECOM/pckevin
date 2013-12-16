/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John624
 */
@Entity
@Table(name = "Livraison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l"),
    @NamedQuery(name = "Livraison.findByIdL", query = "SELECT l FROM Livraison l WHERE l.idL = :idL"),
    @NamedQuery(name = "Livraison.findByNomRecep", query = "SELECT l FROM Livraison l WHERE l.nomRecep = :nomRecep"),
    @NamedQuery(name = "Livraison.findByPrenomRecep", query = "SELECT l FROM Livraison l WHERE l.prenomRecep = :prenomRecep"),
    @NamedQuery(name = "Livraison.findByTelRecep", query = "SELECT l FROM Livraison l WHERE l.telRecep = :telRecep")})
public class Livraison implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idL")
    private Long idL;
    @Size(max = 35)
    @Column(name = "nomRecep")
    private String nomRecep;
    @Size(max = 35)
    @Column(name = "prenomRecep")
    private String prenomRecep;
    @Size(max = 10)
    @Column(name = "telRecep")
    private String telRecep;
    @JoinColumn(name = "adrRecep", referencedColumnName = "idAdresse")
    @ManyToOne
    private Adresse adrRecep;
    @OneToMany(mappedBy = "idLivraison")
    private Collection<Commande> commandeCollection;

    public Livraison() {
    }

    public Livraison(Long idL) {
        this.idL = idL;
    }

    public Long getIdL() {
        return idL;
    }

    public void setIdL(Long idL) {
        this.idL = idL;
    }

    public String getNomRecep() {
        return nomRecep;
    }

    public void setNomRecep(String nomRecep) {
        this.nomRecep = nomRecep;
    }

    public String getPrenomRecep() {
        return prenomRecep;
    }

    public void setPrenomRecep(String prenomRecep) {
        this.prenomRecep = prenomRecep;
    }

    public String getTelRecep() {
        return telRecep;
    }

    public void setTelRecep(String telRecep) {
        this.telRecep = telRecep;
    }

    public Adresse getAdrRecep() {
        return adrRecep;
    }

    public void setAdrRecep(Adresse adrRecep) {
        this.adrRecep = adrRecep;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idL != null ? idL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.idL == null && other.idL != null) || (this.idL != null && !this.idL.equals(other.idL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Livraison[ idL=" + idL + " ]";
    }
    
}
