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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John624
 */
@Entity
@Table(name = "Commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.maxId", query = "SELECT max(c.idC) FROM Commande c"),
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdC", query = "SELECT c FROM Commande c WHERE c.idC = :idC"),
    @NamedQuery(name = "Commande.findByStatus", query = "SELECT c FROM Commande c WHERE c.status = :status"),
    @NamedQuery(name = "Commande.findByMomentC", query = "SELECT c FROM Commande c WHERE c.momentC = :momentC")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idC")
    private Long idC;
    @Lob
    @Column(name = "msg_client")
    private String msgClient;
    @Lob
    @Column(name = "msg_entreprise")
    private String msgEntreprise;
    @Column(name = "status")
    private String status;
    @Column(name = "momentC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date momentC;
    @JoinColumn(name = "idLivraison", referencedColumnName = "idL")
    @ManyToOne
    private Livraison idLivraison;
    @JoinColumn(name = "idU", referencedColumnName = "idE")
    @ManyToOne
    private Entreprise idU;
    @JoinColumn(name = "idCoupon", referencedColumnName = "idCoupon")
    @ManyToOne
    private Coupon idCoupon;

    public Commande() {
    }

    public Commande(Long idC) {
        this.idC = idC;
    }

    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
    }

    public String getMsgClient() {
        return msgClient;
    }

    public void setMsgClient(String msgClient) {
        this.msgClient = msgClient;
    }

    public String getMsgEntreprise() {
        return msgEntreprise;
    }

    public void setMsgEntreprise(String msgEntreprise) {
        this.msgEntreprise = msgEntreprise;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getMomentC() {
        return momentC;
    }

    public void setMomentC(Date momentC) {
        this.momentC = momentC;
    }

    public Livraison getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(Livraison idLivraison) {
        this.idLivraison = idLivraison;
    }

    public Entreprise getIdU() {
        return idU;
    }

    public void setIdU(Entreprise idU) {
        this.idU = idU;
    }

    public Coupon getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(Coupon idCoupon) {
        this.idCoupon = idCoupon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commande[ idC=" + idC + " ]";
    }
    
}
