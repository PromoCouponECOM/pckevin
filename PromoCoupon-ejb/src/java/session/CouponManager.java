/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Coupon;
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
public class CouponManager {
    @PersistenceContext(unitName = "PromoCoupon-ejbPU")
    private EntityManager em;
   
//    public Coupon getCoupon(int i){
//        Query query = em.createNamedQuery("Coupon.findByIdCoupon").setParameter("idCoupon", i);
//        return query;
//    }singleton
    
    public List<Coupon> getAllCoupon() {
        Query query = em.createNamedQuery("Coupon.findAll");
        return query.getResultList();
    }

    public Coupon update(Coupon coupon) {
        return em.merge(coupon);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
