/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entities.Livraison;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import session.LivraisonManager;

/**
 *
 * @author liuju
 */
@Named(value = "livraisonMBean")
@SessionScoped
public class LivraisonMBean implements Serializable{
    
    private List<Livraison> livraisons;
    @EJB
    private Livraison livraison;
    private LivraisonManager livraisonManager;
    
    public LivraisonMBean() {
        livraison = new Livraison();
        livraisonManager=new LivraisonManager();
    }
    
    
    public List<Livraison> getLivraisons(){
        if(livraisons == null || (livraisons.isEmpty())){
         refesh();
        }
        return livraisons;
    }

    private void refesh() {
        if(livraisons == null || (livraisons.isEmpty())){
        livraisons = livraisonManager.getAllLivraison();
        }
     }
    
}
