/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "Coupon")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "Coupon.maxId", query = "SELECT max(c.idCoupon) FROM Coupon c"),
    @NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c"),
    @NamedQuery(name = "Coupon.findByIdCoupon", query = "SELECT c FROM Coupon c WHERE c.idCoupon = :idCoupon"),
    @NamedQuery(name = "Coupon.findByReference", query = "SELECT c FROM Coupon c WHERE c.reference = :reference"),
    @NamedQuery(name = "Coupon.findByStatus", query = "SELECT c FROM Coupon c WHERE c.status = :status"),
    @NamedQuery(name = "Coupon.findByDateVente", query = "SELECT c FROM Coupon c WHERE c.dateVente = :dateVente")})
public class Coupon implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCoupon")
    private BigDecimal idCoupon;
    @Size(max = 10)
    @Column(name = "reference")
    private String reference;
    @Column(name = "status")
    private Short status;
    @Column(name = "dateVente")
    @Temporal(TemporalType.DATE)
    private Date dateVente;
    @JoinColumn(name = "idOffre", referencedColumnName = "idO")
    @ManyToOne
    private Offre idOffre;
    @OneToMany(mappedBy = "idCoupon")
    private Collection<Commande> commandeCollection;

    public Coupon() {
    }

    public Coupon(BigDecimal idCoupon) {
        this.idCoupon = idCoupon;
    }

    public BigDecimal getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(BigDecimal idCoupon) {
        this.idCoupon = idCoupon;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public Offre getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(Offre idOffre) {
        this.idOffre = idOffre;
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
        hash += (idCoupon != null ? idCoupon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coupon)) {
            return false;
        }
        Coupon other = (Coupon) object;
        if ((this.idCoupon == null && other.idCoupon != null) || (this.idCoupon != null && !this.idCoupon.equals(other.idCoupon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Coupon[ idCoupon=" + idCoupon + " ]";
    }
    
}
