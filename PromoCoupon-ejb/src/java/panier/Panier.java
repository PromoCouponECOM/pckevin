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

    public Panier() {
        this.commande = new ArrayList<Item>();
    }

    public void addCoupon(int idOffre, int idCoupon) {
        for (Item item : this.commande) {
            if (item.getIdOffre() == idOffre) {
                item.addCoupon(idCoupon);
                return;
            }
        }
        this.commande.add(new Item(idOffre, idCoupon));
    }

    public void removeOne(int idOffre) {
        for (Item item : this.commande) {
            if (item.getIdOffre() == idOffre) {
                if(item.getQuantity()==1)
                    commande.remove(item);
                else
                    item.removeOne();
                return;
            }
        }
    }
}