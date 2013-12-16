/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Entreprise;
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
public class EntrepriseManager {

    @PersistenceContext(unitName = "PromoCoupon-ejbPU")
    private EntityManager em;

    public List<Entreprise> getAllEntreprise() {
        Query query = em.createNamedQuery("Entreprise.findAll");
        return query.getResultList();
    }

    public Entreprise update(Entreprise entreprise) {
        return em.merge(entreprise);
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Integer nextId(){
        Query query = em.createNamedQuery("Entreprise.maxId");
        return (Integer)query.getResultList().get(0)+1;
    }
}
