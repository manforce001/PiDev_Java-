/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjava;

import CrusUser.Reclamation;
import CrusUser.ServiceUser;
import models.ReclamationUser;
import models.User;

/**
 *
 * @author Nasri
 */
public class SprintJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
 User  p1 = new User(252, "test1", "test1", "test1", "test1", "test1");      

        ServiceUser srv = new ServiceUser();
        System.out.println("insertion ");
        srv.ajouterpersonne(p1);
//srv.modifierpersonne(121, "nasriii");
//srv.supprimerpersonne(121);
        srv.afficherpersonne(); 
        ReclamationUser p2 = new ReclamationUser(1, 252, "test1", "test1", "test1"); 

        Reclamation rec = new Reclamation(); 
        rec.ajouterReclamation(p2);
        System.out.println(" nouveau test de reclamation");
        rec.afficherReclamation();
       
    }    
}
