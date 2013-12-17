/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Utilisateur;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import session.UtilisateurManager;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author John624
 */
@Named(value = "UtilisateurMBean")
@RequestScoped
public class UtilisateurMBean implements Serializable {

    @EJB
    private UtilisateurManager utilisateurM;
    private List<Utilisateur> users;
    private Utilisateur user;

    public UtilisateurMBean() {
        user = new Utilisateur();
    }

    public List<Utilisateur> getUsers() {
        if ((users == null) || (users.isEmpty())) {
            refresh();
        }
        return users;
    }

    private void refresh() {
        if ((users == null) || (users.isEmpty())) {
            users = utilisateurM.getAllUtilisateurs();
        }
    }

    
    /**
     * returns details of a customer. Useful for displaying in a form a
     * customer's details
     *
     * @return
     */
    public Utilisateur getDetails() {
        return user;
    }

    public Utilisateur getUser(){
        return user;
    }

    
    /**
     * Action handler - Called when a line in the table is clicked
     *
     * @param utilisateur
     * @return
     */
    public String showDetails(Utilisateur user) {
        this.user = user;
        return "UtilisateurDetails"; // will display CustomerDetails.xml JSF page  
    }

    /**
     * Action handler - update the customer model in the database. called when
     * one press the update button in the form
     *
     * @return
     */
    public String update() {
        user = utilisateurM.update(user);
        return "UtilisateurList";
    }

    public String update(Utilisateur u) {
        user = utilisateurM.update(u);
        return "UtilisateurList"; 
    }
    /**
     * Action handler - returns to the list of customers in the table
     */
    public String list() {
        System.out.println("###LIST###");
        return "UtilisateurList";
    }

}
