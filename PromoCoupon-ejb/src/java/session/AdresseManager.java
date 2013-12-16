/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Adresse;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author John624
 */
@Stateless
@LocalBean
public class AdresseManager {
    @PersistenceContext(unitName = "PromoCoupon-ejbPU")
    private EntityManager em;

    public List<Adresse> getAllAdresses() {
        Query query=em.createNamedQuery("Adresse.findAll");
        return query.getResultList();
    }

    public Adresse update(Adresse adresse) {
        return em.merge(adresse);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
