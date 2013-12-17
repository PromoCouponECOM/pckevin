/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Categorie;
import entities.Offre;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import session.OffreManager;

/**
 *
 * @author John624
 */
@Named(value = "inscriptionOffreMBean")
@RequestScoped
public class InscriptionOffreMBean {

    /**
     * Creates a new instance of InscriptionOffreMBean
     */
    
    private Map<String, String> settings;
    
    @EJB
    private OffreManager offreManager;
    private Offre offre;
    
    private Date dateDebut;
    private Date dateFin;
    
    public InscriptionOffreMBean() {
        settings= new HashMap<String,String>();
        offre = new Offre();
        dateDebut= new Date();
        dateFin = new Date();
    }
    
    public  void init (){
        offreManager = new OffreManager();
    }
    
    public void save(){
        
        //update db adresse
        offre.setIdO(Long.valueOf(offreManager.nextId()));
        //TODO
        //offre.setCategorie(new Categorie());
        offre.setConseille(settings.get("conseille"));
        
        offre.setDateDebut(dateDebut);
        offre.setDateFin(dateFin);
        offre.setDscription(settings.get("description"));
        offre.setImage(settings.get("image"));
        //String limite = settings.get("limite");
        offre.setLimite(Short.valueOf(settings.get("limite")));
        offre.setNbCoupons(Short.valueOf(settings.get("nbCoupons")));
        //Long pa = Long.valueOf(settings.get("prixActuel"));
        offre.setPrixActuel(new BigDecimal(settings.get("prixActuel")));
        offre.setPrixOrigin(new BigDecimal(settings.get("prixOrigin")));
        offre.setTitle(settings.get("title"));
        offre.setValidation(Integer.valueOf(settings.get("validation")));
        offre.setDateModif(new Date());
        offreManager.update(offre);
    }
    
     public Map<String, String> getSettings() {
        return settings;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
