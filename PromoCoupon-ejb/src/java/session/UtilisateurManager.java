/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Utilisateur;
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
public class UtilisateurManager {

    @PersistenceContext(unitName = "PromoCoupon-ejbPU")
    private EntityManager em;

    //executes a "named query" whose name is "Utilisateur.findall". Look at the beginning of the file Utilisateur.java, you will find this query. It's equivalent to a select * from Utilisateur. But as we are working with objects, in that case we will return a List of Utilisateurs, not tuples.
    public List<Utilisateur> getAllUtilisateurs() {
        Query query = em.createNamedQuery("Utilisateur.findAll");
        return query.getResultList();
    }
    
    public Utilisateur update(Utilisateur utilisateur) {
        return em.merge(utilisateur);
    }

    public void persist(Object object) {
        em.persist(object);
    }
        
    public Integer nextId(){
        Query query = em.createNamedQuery("Utilisateur.maxId");
        return (Integer)query.getResultList().get(0)+1;
    }

}
