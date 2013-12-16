/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Adresse;
import entities.Utilisateur;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import session.AdresseManager;
import session.UtilisateurManager;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author liuju
 */
@Named(value = "signupMBean")
@RequestScoped
public class SignupMBean implements Serializable {

    /**
     * Creates a new instance of SignupMBean
     */
    private Adresse adresse;
    private Utilisateur utilisateur;
    @EJB
    private AdresseManager adresseManager;
    private UtilisateurManager utilisateurManager;
    
    public SignupMBean() {
        adresse = new Adresse();
        utilisateur = new Utilisateur();
    }  
    
    public Adresse getAdresse(){
        return this.adresse;
    }
    
    public Utilisateur getUser(){
        return this.utilisateur;
    }
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        //adresse.setIdAdresse(adresseManager.nextId());
        adresse = utilisateur.getAdrU();
        adresse = adresseManager.update(adresse);
        utilisateur = utilisateurManager.update(utilisateur); 
        return "UtilisateurList"; // will display the customer list in a table  
    }  
}
