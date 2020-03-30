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
    private String nom ; 

    public ReclamationUser(int id, int id_user, String nom) 
    {
        this.id = id;
        this.id_user = id_user;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "ReclamationUser{" + "id=" + id + ", id_user=" + id_user + ", nom=" + nom + '}';
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
   
   
    
    
}
