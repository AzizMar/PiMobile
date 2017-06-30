/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author azizx
 */
public class Voiture {
    
    private int id,nbPlaces;
    private String matricule,marque,description;
    public int proprietaire_id;
    
    
    public Voiture() {
    }

    public int getProprietaire_id() {
        return proprietaire_id;
    }

    public void setProprietaire_id(int proprietaire_id) {
        this.proprietaire_id = proprietaire_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    
    
    
    
    
    
}
