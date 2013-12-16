/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Livraison;
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
public class LivraisonManager {

    @PersistenceContext(unitName = "ECOM-ejbPU")
    private EntityManager em;

    public List<Livraison> getAllLivraison() {
        Query query = em.createNamedQuery("Livraison.findAll");
        return query.getResultList();
    }

    public Livraison update(Livraison livraison) {
        return em.merge(livraison);
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Integer nextId(){
        Query query = em.createNamedQuery("Livraison.maxId");
        return query.getResultList().indexOf(0)+1;
    }

}
