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

/**
 *
 * @author John624
 */
@Stateless
@LocalBean
public class LivraisonManager {

    @PersistenceContext(unitName = "PromoCoupon-ejbPU")
    private EntityManager em;

    public List<Livraison> getAllLivraison() {
        return null;
    }

    public Livraison update(Livraison livraison) {
        return null;
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
