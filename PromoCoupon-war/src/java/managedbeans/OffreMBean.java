/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Offre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import session.OffreManager;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author John624
 */
@Named(value = "offreMBean")
@SessionScoped
public class OffreMBean implements Serializable {

    private List<Offre> offres;
    private List<Offre> offresSelected;

    @EJB
    private OffreManager offreManager;
    private Offre offre;
    private Offre selectedOffre;

    private String type;

    /**
     * Creates a new instance of OffreMBean
     */
    public OffreMBean() {
        Offre offre = new Offre();
    }

    public String calculerPourcentage(double prixActuel, double prixOrigin) {
        double res = Math.round(100 - (prixActuel * 100 / prixOrigin));
        return "-" + res + "%";
    }

    public String dateValidite(Date dateDebut, Date dateFin) {
        if (selectedOffre != null) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(dateDebut);

            int jourDeb = cal.get(Calendar.DATE);
            String jourDebut;
            if (jourDeb < 10) {
                jourDebut = "0" + jourDeb;
            } else {
                jourDebut = "" + jourDeb;
            }
            int moisDeb = cal.get(Calendar.MONTH);
            String moisDebut;
            moisDeb++;
            if (moisDeb < 10) {
                moisDebut = "0" + moisDeb;
            } else {
                moisDebut = "" + moisDeb;
            }
            int anneeDebut = cal.get(Calendar.YEAR);

            cal.setTime(dateFin);

            int jourF = cal.get(Calendar.DATE);
            String jourFin;
            if (jourF < 10) {
                jourFin = "0" + jourF;
            } else {
                jourFin = "" + jourF;
            }
            int moisF = cal.get(Calendar.MONTH);
            String moisFin;
            moisF++;
            if (moisF < 10) {
                moisFin = "0" + moisF;
            } else {
                moisFin = "" + moisF;
            }
            int anneeFin = cal.get(Calendar.YEAR);


            return "du " + jourDebut + "/" + moisDebut + "/" + anneeDebut + " au " + jourFin + "/" + moisFin + "/" + anneeFin;
        }
        return "";
    }

    public Offre getSelectedOffre() {
        //System.out.println("getSelectedOffre: "+selectedOffre.getIdO().longValue());
        return selectedOffre;
    }

    public void setSelectedOffre(Offre selectedOffre) {
        //System.out.println("setSelectedOffre: "+selectedOffre.getIdO().longValue());
        this.selectedOffre = selectedOffre;
    }
    
    public List<Offre> getOffres() {
        if ((offres == null) || (offres.isEmpty())) {
            offres = offreManager.getAllOffre();
        }
        return offreManager.getAllOffre();
    }

    public List<Offre> getOffresSelected() {
        if (type == null || type.equals("tous")){
            return offreManager.getAllOffre();
        }
        offresSelected = offreManager.getSpecialOffres("Resto");
        //System.out.println("###"+offresSelected+"###");
        return offresSelected;
    }

    public String update() {
        System.out.println("###UPDATE###");
        offre = offreManager.update(offre);
        return "OffreList"; // will display the Offre list in a table 
    }

    /**
     * Action handler - Called when a line in the table is clicked
     *
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

    public String showTypeOffre() {
        //this.getOffresSelected();
        //System.out.println("###" + type + "###");
        //List<Offre> tmp = new ArrayList<Offre>();
        //tmp = offreManager.getSpecialOffres(type);
        return "touteslespromos";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
