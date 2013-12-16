/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Commande;
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
public class CommandeManager {
    @PersistenceContext(unitName = "PromoCoupon-ejbPU")
    private EntityManager em;

    public List<Commande> getAllCommande() {
           Query query = em.createNamedQuery("Commande.findAll");
           return query.getResultList();
    }

    public Commande update(Commande commande) {
        return em.merge(commande);
    }

    public void persist(Object object) {
        em.persist(object);
    }
            
    public Integer nextId(){
        Query query = em.createNamedQuery("Commande.maxId");
        return (Integer)query.getResultList().get(0)+1;
    }
}
