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
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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

    public Boolean authUtilisateur(String login, String password) {
        Query query = em.createNamedQuery("Utilisateur.findByMailU");
        query.setParameter("mailU", login);
        List<Utilisateur> lu = query.getResultList();
        for (Utilisateur u : lu) {
            if (u.getPassU().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Utilisateur insertUtilisateur() {

        em.close();
        return null;
    }
    //update(Utilisateur utilisateur)... updates the database content with the value of the Customer passed as a parameter. The em.merge(utilisateur);

    public Utilisateur update(Utilisateur utilisateur) {
        return em.merge(utilisateur);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public Integer nextId() {
        System.out.println("###yyyyyyyyyyyyyyyyyy###");
        Query query = em.createNamedQuery("Utilisateur.maxId");
        if (query.getResultList() == null || query.getResultList().isEmpty()) {
            return new Integer(0);
        }

        Integer res = (Integer) query.getResultList().get(0);
        return res + 1;
        //return new Integer(0);
    }

    public boolean emailUsed(String mail) {
        Query query = em.createNamedQuery("Utilisateur.findByMailU");
        query.setParameter("mailU", mail);
        return !query.getResultList().isEmpty();
    }

    public Utilisateur getUserById(Integer id) {
        List<Utilisateur> users = null;
        users = getAllUtilisateurs();

        System.out.println(id);
        for (Utilisateur tmp : users) {
            System.out.println(tmp);
            System.out.println(tmp.getIdU() == id);
            if (tmp.getIdU().intValue() == id) {
                System.out.println("here");
                return tmp;
            }
        }
        return null;
    }
}
