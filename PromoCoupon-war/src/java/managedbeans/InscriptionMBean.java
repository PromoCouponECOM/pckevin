/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Adresse;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import session.AdresseManager;
import session.UtilisateurManager;

/**
 *
 * @author liu
 */
@Named(value = "inscriptionMBean")
@SessionScoped

public class InscriptionMBean implements Serializable{
    //@PersistenceContext(unitName = "PromoCoupon-ejbPU")

    private Map<String, String> settings;
    @EJB
    private AdresseManager adrM;
    @EJB
    private UtilisateurManager userM;
    private Adresse adr;
    private Utilisateur user;
    
    public InscriptionMBean() {
        settings = new HashMap<String, String>();
        adr = new Adresse();
        user = new Utilisateur();
    }
  
    public void init(){
        adrM.getAllAdresses();
        userM.getAllUtilisateurs();
    }

    
    public String save() {
//        adr.setIdAdresse(Long.parseLong(settings.get("idAdr")));
//        adr.setNumEtRue(settings.get("rue"));
//        adr.setComple(settings.get("compl"));
//        adr.setVille(settings.get("ville"));
//        adr.setPays(settings.get("pays"));
//        adr.setCodePostale(settings.get("code"));
        
        adr.setIdAdresse(Long.parseLong(settings.get("idAdr")));
        adr.setNumEtRue(settings.get("rue"));
        adr.setComple(settings.get("compl"));
        adr.setVille(settings.get("ville"));
        adr.setPays(settings.get("pays"));
        adr.setCodePostale(settings.get("code"));
        adr.setDateModif(new Date());
        adrM.update(adr);

        
        //em.merge(adr);
              
//        user.setIdU(Integer.parseInt(settings.get("idUser")));
//        user.setNomU(settings.get("nom"));
//        user.setPrenomU(settings.get("prenom"));
//        user.setSexe(settings.get("sexe").charAt(0));
//        user.setPassU(settings.get("pwd"));
//        user.setMailU(settings.get("mail"));
//        user.setTelU(settings.get("tel"));
//        user.setAdrU(adr);
        
         user.setIdU(Integer.parseInt(settings.get("idUser")));
        user.setNomU(settings.get("nom"));
        user.setPrenomU(settings.get("prenom"));
        user.setSexe(settings.get("sexe").charAt(0));
        user.setPassU(settings.get("pwd"));
        user.setMailU(settings.get("mail"));
        user.setTelU(settings.get("tel"));
        user.setAdrU(adr);
        user.setDataModif(new Date());
        userM.update(user);
        
        
        return "UtilisateurList";
    }

    public Map<String, String> getSettings() {
        return settings;
    }
}
