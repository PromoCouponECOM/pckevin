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
@Table(name = "Adresse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.maxId", query = "SELECT max(a.idAdresse) FROM Adresse a"),
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
    @NamedQuery(name = "Adresse.findByIdAdresse", query = "SELECT a FROM Adresse a WHERE a.idAdresse = :idAdresse"),
    @NamedQuery(name = "Adresse.findByNumEtRue", query = "SELECT a FROM Adresse a WHERE a.numEtRue = :numEtRue"),
    @NamedQuery(name = "Adresse.findByComple", query = "SELECT a FROM Adresse a WHERE a.comple = :comple"),
    @NamedQuery(name = "Adresse.findByCodePostale", query = "SELECT a FROM Adresse a WHERE a.codePostale = :codePostale"),
    @NamedQuery(name = "Adresse.findByVille", query = "SELECT a FROM Adresse a WHERE a.ville = :ville"),
    @NamedQuery(name = "Adresse.findByPays", query = "SELECT a FROM Adresse a WHERE a.pays = :pays"),
    @NamedQuery(name = "Adresse.findByDateModif", query = "SELECT a FROM Adresse a WHERE a.dateModif = :dateModif")})
public class Adresse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdresse")
    private Long idAdresse;
    @Size(max = 100)
    @Column(name = "numEtRue")
    private String numEtRue;
    @Size(max = 100)
    @Column(name = "comple")
    private String comple;
    @Size(max = 5)
    @Column(name = "codePostale")
    private String codePostale;
    @Size(max = 35)
    @Column(name = "ville")
    private String ville;
    @Size(max = 35)
    @Column(name = "pays")
    private String pays;
    @Column(name = "dateModif")
    @Temporal(TemporalType.DATE)
    private Date dateModif;
    @OneToMany(mappedBy = "adrU")
    private Collection<Utilisateur> utilisateurCollection;
    @OneToMany(mappedBy = "adrRecep")
    private Collection<Livraison> livraisonCollection;
    @OneToMany(mappedBy = "adrE")
    private Collection<Entreprise> entrepriseCollection;

    public Adresse() {
    }

    public Adresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNumEtRue() {
        return numEtRue;
    }

    public void setNumEtRue(String numEtRue) {
        this.numEtRue = numEtRue;
    }

    public String getComple() {
        return comple;
    }

    public void setComple(String comple) {
        this.comple = comple;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @XmlTransient
    public Collection<Livraison> getLivraisonCollection() {
        return livraisonCollection;
    }

    public void setLivraisonCollection(Collection<Livraison> livraisonCollection) {
        this.livraisonCollection = livraisonCollection;
    }

    @XmlTransient
    public Collection<Entreprise> getEntrepriseCollection() {
        return entrepriseCollection;
    }

    public void setEntrepriseCollection(Collection<Entreprise> entrepriseCollection) {
        this.entrepriseCollection = entrepriseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdresse != null ? idAdresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.idAdresse == null && other.idAdresse != null) || (this.idAdresse != null && !this.idAdresse.equals(other.idAdresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Adresse[ idAdresse=" + idAdresse + " ]";
    }
    
}
