/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.user;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.util.Date;

/**
 *
 * @author azizx
 */
public class Annonces {
    private UIBuilder uib;
     private Form listAnnonces;
     private int id;
      private int userId;
      private int voitureId;
     private String depart;
     private String arrivee;
     private String heuredepart;
     private String date;
      private int nbplace;
     private String prix;
     private String  disponible;
     private String  bagages;  
     private String  animal;
     private String  fumer;
     private String  description;
     
     

    public Annonces() {
    }
     
    
    public Annonces (Resources theme,Form f){
    
    listAnnonces = new Form(BoxLayout.y());
         listAnnonces.setTitle("Mes Annonces ");
        listAnnonces.refreshTheme();;
        listAnnonces.show();
    
    }

    public UIBuilder getUib() {
        return uib;
    }

    public void setUib(UIBuilder uib) {
        this.uib = uib;
    }

    public Form getListAnnonces() {
        return listAnnonces;
    }

    public void setListAnnonces(Form listAnnonces) {
        this.listAnnonces = listAnnonces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVoitureId() {
        return voitureId;
    }

    public void setVoitureId(int voitureId) {
        this.voitureId = voitureId;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(String heuredepart) {
        this.heuredepart = heuredepart;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getBagages() {
        return bagages;
    }

    public void setBagages(String bagages) {
        this.bagages = bagages;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getFumer() {
        return fumer;
    }

    public void setFumer(String fumer) {
        this.fumer = fumer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}