    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zalgo
 */
public class Item {

    private int idOffre;
    private List<Integer> idCoupons;

    public Item(int idOffre, int idCoupon) {
        this.idOffre = idOffre;
        this.idCoupons = new ArrayList<Integer>();
        this.idCoupons.add(new Integer(idCoupon));
    }

    public void addCoupon(int idCoupon) {
        this.idCoupons.add(idCoupon);
    }

    public int removeOne() {
        if (this.idCoupons.size() > 0) {
            return this.idCoupons.remove(0);
        } else {
            return -1;
        }
    }

    public int getQuantity() {
        return this.idCoupons.size();
    }

    public int getIdOffre(){
        return this.idOffre;
    }
    
    public Boolean equals(Item item) {
        return this.idOffre == item.idOffre;
    }
}
