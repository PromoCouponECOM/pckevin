/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Adresse;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.PersistenceContext;
import session.AdresseManager;
import session.EntrepriseManager;
import session.UtilisateurManager;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author John624
 */
@Named(value="sessionMBean")
@SessionScoped
public class SessionMBean implements Serializable{
    public enum State { NotConnected, ConnectedAsCustomer, ConnectedAsOrganization, ConnectedAsAdmin }
    
    private State state;
    private Integer idUser;
    private String loginName;
    
    
    @EJB
    private UtilisateurManager UM;
    @EJB
    private EntrepriseManager EM;
    
    public SessionMBean() {
        this.state = State.NotConnected;
        this.loginName = null;
        this.idUser = null;
        UM = new UtilisateurManager();
        EM = new EntrepriseManager();
    }
     /** 
     * returns customer list for display in a datatable DataTable 
     * @return 
     */  
    public String userConnect(String login, String password) {
        if(UM.authUtilisateur(login, password)){
            this.loginName=login;
            this.state=State.ConnectedAsCustomer;
            return "index";
        }
        else{
            if(EM.authEntreprise(login, password)){
                this.loginName=login;
                this.state=State.ConnectedAsOrganization;
                return "offresEntreprise";
            }
        }
        return "#";
    }
    
    public State adminConnect(String login, String password){
        return State.NotConnected;
    }
    
    public State getState(){
        return this.state;
    }
    
    public Boolean isConnectedAsCustomer(){
        return this.state == State.ConnectedAsCustomer;
    }

    public Boolean isConnectedAsOrganization(){
        return this.state == State.ConnectedAsOrganization;
    }
    
    
    public String getLogin(){
        return this.loginName;
    }
  
}
