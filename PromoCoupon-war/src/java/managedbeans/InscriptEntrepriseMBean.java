/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Adresse;
import entities.Entreprise;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.PersistenceContext;
import session.AdresseManager;
import session.EntrepriseManager;

/**
 *
 * @author John624
 */

@Named(value = "inscripEntrepriseMBean")
@SessionScoped
public class InscriptEntrepriseMBean implements Serializable {

    //@PersistenceContext(unitName = "PromoCoupon-ejbPU")
    private Map<String, String> settings;
    @EJB
    private AdresseManager adrM;
    @EJB
    private EntrepriseManager entM;
    
    private Adresse adr;
    private Entreprise entrp;
            
    public InscriptEntrepriseMBean() {
        settings= new HashMap<String,String>();
        adr = new Adresse();
        entrp = new Entreprise();
    }
    
    
    public void init (){
        adrM = new AdresseManager();
        entM = new EntrepriseManager();
    }
    
    
    public void save(){
        
        //update db adresse
        adr.setIdAdresse(Long.parseLong(settings.get("idAdr")));
        adr.setNumEtRue(settings.get("rue"));
        adr.setComple(settings.get("compl"));
        adr.setVille(settings.get("ville"));
        adr.setPays(settings.get("pays"));
        adr.setCodePostale(settings.get("code"));
        adr.setDateModif(new Date());
        adrM.update(adr);
        
        //
        //in=new Integer(settings.get("idEnp"));
        //entrp.setIdE(Integer());
    }
    
     public Map<String, String> getSettings() {
        return settings;
    }
}
