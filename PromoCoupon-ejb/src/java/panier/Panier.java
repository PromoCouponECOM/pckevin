package panier;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zalgo
 */
public class Panier {

    List<Item> commande;
    double prixTotal;

    public Panier() {
        this.commande = new ArrayList<Item>();
        prixTotal = 0;
    }

    public void addCoupon(int idOffre, long idCoupon, double prix) {
        for (Item item : this.commande) {
            if (item.getIdOffre() == idOffre) {
                item.addCoupon(idCoupon);
                return;
            }
        }
        this.commande.add(new Item(idOffre, idCoupon));
        this.prixTotal+=prix;
    }

    public void removeOne(int idOffre, double prix) {
        for (Item item : this.commande) {
            if (item.getIdOffre() == idOffre) {
                if(item.getQuantity()==1)
                    commande.remove(item);
                else
                        item.removeOne();
                this.prixTotal-=prix;
                return;
            }
        }
    }
    
    public List<Integer> getOffres(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Item item : this.commande)
            res.add(item.getIdOffre());
        return res;
    }
    public Boolean contientOffre(int idOffre){
        return getOffres().contains(idOffre);
    }
    public int getQuantity(int idOffre){
        for(Item item : this.commande)
            if(item.getIdOffre()==idOffre)
                return item.getQuantity();
        return 0;
    }
    public double getPrixTotal(){
        return this.prixTotal;
    }
}