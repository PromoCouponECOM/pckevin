/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entities.Coupon;
import entities.Livraison;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author liuju
 */
@Named(value = "inscriptionCMDMBean")
@SessionScoped
public class InscriptionCMDMBean implements Serializable{

    private Map<String, String> settings;
    @EJB
    private CouponMBean couponM;
    @EJB
    private LivraisonMBean livM;
    @EJB
    private UtilisateurMBean userM;
    
    private Utilisateur user;
    private Coupon coupon;
    private Livraison liv;
    
    /**
     * Creates a new instance of InscriptionCMDMBean
     */
    public InscriptionCMDMBean() {
        settings = new HashMap<String, String>();
        user = new Utilisateur();
        coupon = new Coupon();
        liv = new Livraison();
    }

    public String save() {
        user = userM.getUserById(new Integer(0));
        if(user == null)
            return "ERROR.xhtml?msg=userInconnu";
        
        coupon = couponM.getCouponById(new Integer(0));
        if(coupon == null)
            return "ERROR.xhtml?msg=userInconnu";

        return "CommandeList";
    }
}
