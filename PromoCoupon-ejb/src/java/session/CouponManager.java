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
    
    public List<Coupon> getAllCoupons() {
        Query query = em.createNamedQuery("Coupon.findAll");
        return query.getResultList();
    }

    public Coupon update(Coupon coupon) {
        return em.merge(coupon);
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Integer nextId(){
        Query query = em.createNamedQuery("Coupon.maxId");
        Integer res = (Integer)query.getResultList().get(0);
        if(res==null)
            return new Integer(0);
        return res+1;
    }

    public boolean exiteCoupon(String reference) {
        Query query = em.createNamedQuery("Coupon.findByReference");
        query.setParameter("reference", reference);
        return !query.getResultList().isEmpty();
    }
}
