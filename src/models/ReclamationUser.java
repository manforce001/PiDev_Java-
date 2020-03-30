/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Nasri
 */
public class ReclamationUser
{
   
    private int id;
    private int id_user; 
    private String sujet ; 
    private String reclamation ; 
    private String etat ; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReclamationUser(int id, int id_user, String sujet, String reclamation, String etat) {
        this.id = id;
        this.id_user = id_user;
        this.sujet = sujet;
        this.reclamation = reclamation;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "ReclamationUser{" + "id=" + id + ", id_user=" + id_user + ", sujet=" + sujet + ", reclamation=" + reclamation + ", etat=" + etat + '}';
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getReclamation() {
        return reclamation;
    }

    public void setReclamation(String reclamation) {
        this.reclamation = reclamation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }



    
   
   
    
    
}
