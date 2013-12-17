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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "Entreprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreprise.maxId", query = "SELECT max(e.idE) FROM Entreprise e"),
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e"),
    @NamedQuery(name = "Entreprise.findByIdE", query = "SELECT e FROM Entreprise e WHERE e.idE = :idE"),
    @NamedQuery(name = "Entreprise.findByNomE", query = "SELECT e FROM Entreprise e WHERE e.nomE = :nomE"),
    @NamedQuery(name = "Entreprise.findByMailE", query = "SELECT e FROM Entreprise e WHERE e.mailE = :mailE"),
    @NamedQuery(name = "Entreprise.findByPassE", query = "SELECT e FROM Entreprise e WHERE e.passE = :passE"),
    @NamedQuery(name = "Entreprise.findByTelE", query = "SELECT e FROM Entreprise e WHERE e.telE = :telE"),
    @NamedQuery(name = "Entreprise.findByConsulE", query = "SELECT e FROM Entreprise e WHERE e.consulE = :consulE"),
    @NamedQuery(name = "Entreprise.findByValidation", query = "SELECT e FROM Entreprise e WHERE e.validation = :validation"),
    @NamedQuery(name = "Entreprise.findBySiret", query = "SELECT e FROM Entreprise e WHERE e.siret = :siret"),
    @NamedQuery(name = "Entreprise.findByRib", query = "SELECT e FROM Entreprise e WHERE e.rib = :rib"),
    @NamedQuery(name = "Entreprise.findByDateModif", query = "SELECT e FROM Entreprise e WHERE e.dateModif = :dateModif")})
public class Entreprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idE")
    private Integer idE;
    @Size(max = 30)
    @Column(name = "nomE")
    private String nomE;
    @Size(max = 30)
    @Column(name = "mailE")
    private String mailE;
    @Size(max = 30)
    @Column(name = "passE")
    private String passE;
    @Size(max = 10)
    @Column(name = "telE")
    private String telE;
    @Lob
    @Column(name = "resuE")
    private String resuE;
    @Size(max = 50)
    @Column(name = "consulE")
    private String consulE;
    @Column(name = "validation")
    private Integer validation;
    @Size(max = 14)
    @Column(name = "siret")
    private String siret;
    @Size(max = 27)
    @Column(name = "rib")
    private String rib;
    @Column(name = "dateModif")
    @Temporal(TemporalType.DATE)
    private Date dateModif;
    @OneToMany(mappedBy = "idU")
    private Collection<Commande> commandeCollection;
    @JoinColumn(name = "adrE", referencedColumnName = "idAdresse")
    @ManyToOne
    private Adresse adrE;
    @OneToMany(mappedBy = "idE")
    private Collection<Offre> offreCollection;

    public Entreprise() {
    }

    public Entreprise(Integer idE) {
        this.idE = idE;
    }

    public Integer getIdE() {
        return idE;
    }

    public void setIdE(Integer idE) {
        this.idE = idE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getMailE() {
        return mailE;
    }

    public void setMailE(String mailE) {
        this.mailE = mailE;
    }

    public String getPassE() {
        return passE;
    }

    public void setPassE(String passE) {
        this.passE = passE;
    }

    public String getTelE() {
        return telE;
    }

    public void setTelE(String telE) {
        this.telE = telE;
    }

    public String getResuE() {
        return resuE;
    }

    public void setResuE(String resuE) {
        this.resuE = resuE;
    }

    public String getConsulE() {
        return consulE;
    }

    public void setConsulE(String consulE) {
        this.consulE = consulE;
    }

    public Integer getValidation() {
        return validation;
    }

    public void setValidation(Integer validation) {
        this.validation = validation;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    public Adresse getAdrE() {
        return adrE;
    }

    public void setAdrE(Adresse adrE) {
        this.adrE = adrE;
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
        hash += (idE != null ? idE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.idE == null && other.idE != null) || (this.idE != null && !this.idE.equals(other.idE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entreprise[ idE=" + idE + " ]";
    }
    
}
