/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Offre;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import session.OffreManager;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author John624
 */
@Named(value="offreMBean")
@RequestScoped
public class OffreMBean implements Serializable{
    private List<Offre> offres;
    @EJB
    private OffreManager offreManager;
    private Offre offre;
    /**
     * Creates a new instance of OffreMBean
     */
    
    public OffreMBean() {
        Offre offre = new Offre();
    }
    
    public List<Offre> getOffres(){
        if((offres == null) || (offres.isEmpty()))
            offres = offreManager.getAllOffre();  
        return offreManager.getAllOffre(); 
    }
    
    
    public String update(){
        System.out.println("###UPDATE###");  
        offre = offreManager.update(offre);  
        return "OffreList"; // will display the Offre list in a table 
    }
    
      /** 
     * Action handler - Called when a line in the table is clicked 
     * @param offre 
     * @return 
     */  
    public String showDetails(Offre offre) {  
        this.offre = offre;  
        return "OffreDetails"; // will display CustomerDetails.xml JSF page  
    } 
    
    /** 
     * Action handler - returns to the list of Offres in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "OffreList";  
    }  
}
