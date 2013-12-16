/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Adresse;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.PersistenceContext;
import session.AdresseManager;

/**
 *
 * @author John624
 */
@Named(value="adresseMBean")
@RequestScoped
public class AdresseMBean implements Serializable{
    
    private List<Adresse> adresses;
    private Adresse adresse;
    @EJB
    private AdresseManager adresseManager;
    
    public AdresseMBean() {
        adresse=new Adresse();
        adresseManager = new AdresseManager();
    }
     /** 
     * returns customer list for display in a datatable DataTable 
     * @return 
     */  
    public List<Adresse> getAdresses() {  
        if((adresses == null) || (adresses.isEmpty()))
            adresses = adresseManager.getAllAdresses();  
        return adresseManager.getAllAdresses();  
    }  
  
//    public void refresh() {  
//        tousLesComptes = compteBancaireFacade.findAll();  
//    }  
  
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Adresse getDetails() {  
        return adresse;  
    }  
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param adresse 
     * @return 
     */  
    public String showDetails(Adresse adresse) {  
        this.adresse = adresse;  
        return "AdresseDetails"; // will display CustomerDetails.xml JSF page  
    }  
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String  update() {  
        System.out.println("###UPDATE###");  
        adresse = adresseManager.update(adresse);  
        return "AdresseList"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "AdresseList";  
    }  

    public void update(Adresse adrU) {
        System.out.println("###UPDATE###");  
        adresseManager.update(adrU);  
    }
}
