/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John624
 */
@Entity
@Table(name = "Utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.maxId", query = "SELECT max(u.idU) FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdU", query = "SELECT u FROM Utilisateur u WHERE u.idU = :idU"),
    @NamedQuery(name = "Utilisateur.findByMailU", query = "SELECT u FROM Utilisateur u WHERE u.mailU = :mailU"),
    @NamedQuery(name = "Utilisateur.findByTelU", query = "SELECT u FROM Utilisateur u WHERE u.telU = :telU"),
    @NamedQuery(name = "Utilisateur.findByPassU", query = "SELECT u FROM Utilisateur u WHERE u.passU = :passU"),
    @NamedQuery(name = "Utilisateur.findByNomU", query = "SELECT u FROM Utilisateur u WHERE u.nomU = :nomU"),
    @NamedQuery(name = "Utilisateur.findByPrenomU", query = "SELECT u FROM Utilisateur u WHERE u.prenomU = :prenomU"),
    @NamedQuery(name = "Utilisateur.findBySexe", query = "SELECT u FROM Utilisateur u WHERE u.sexe = :sexe"),
    @NamedQuery(name = "Utilisateur.findByDataModif", query = "SELECT u FROM Utilisateur u WHERE u.dataModif = :dataModif")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idU")
    private Integer idU;
    @Size(max = 20)
    @Column(name = "mailU", unique=true)
    private String mailU;
    @Size(max = 10)
    @Column(name = "telU")
    private String telU;
    @Size(max = 30)
    @Column(name = "passU")
    private String passU;
    @Size(max = 30)
    @Column(name = "nomU")
    private String nomU;
    @Size(max = 30)
    @Column(name = "prenomU")
    private String prenomU;
    @Column(name = "sexe")
    private Character sexe;
    @Column(name = "dataModif")
    @Temporal(TemporalType.DATE)
    private Date dataModif;
    @JoinColumn(name = "adrU", referencedColumnName = "idAdresse")
    @ManyToOne
    private Adresse adrU;

    public Utilisateur() {
    }

    public Utilisateur(Integer idU) {
        this.idU = idU;
    }

    public Integer getIdU() {
        return idU;
    }

    public void setIdU(Integer idU) {
        this.idU = idU;
    }

    public String getMailU() {
        return mailU;
    }

    public void setMailU(String mailU) {
        this.mailU = mailU;
    }

    public String getTelU() {
        return telU;
    }

    public void setTelU(String telU) {
        this.telU = telU;
    }

    public String getPassU() {
        return passU;
    }

    public void setPassU(String passU) {
        this.passU = passU;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public String getPrenomU() {
        return prenomU;
    }

    public void setPrenomU(String prenomU) {
        this.prenomU = prenomU;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    public Date getDataModif() {
        return dataModif;
    }

    public void setDataModif(Date dataModif) {
        this.dataModif = dataModif;
    }

    public Adresse getAdrU() {
        return adrU;
    }

    public void setAdrU(Adresse adrU) {
        this.adrU = adrU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idU != null ? idU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idU == null && other.idU != null) || (this.idU != null && !this.idU.equals(other.idU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Utilisateur[ idU=" + idU + " ]";
    }
    
}
