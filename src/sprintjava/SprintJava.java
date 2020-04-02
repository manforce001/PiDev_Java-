/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjava;

import CrusUser.Reclamation;
import CrusUser.ReponseReclamationAdmin;
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
     
        User  p1 = new User(252, "test1", "test1", "test1", "test1", "test1","test1","test1");      
        User  p2 = new User(253, "test2", "test2", "test2", "test2", "test2","test2","test2"); 
        User  p3 = new User(254, "test2", "test2", "test2", "test2", "test2","test2","test2"); 


        ServiceUser srv = new ServiceUser();
        System.out.println("insertion ");
        /* test insertion */
        srv.ajouterpersonne(p1);
        srv.ajouterpersonne(p2);
        srv.ajouterpersonne(p3);
        
        /* test delete*/
        srv.supprimerpersonne(252);
        
        /* test de modificztion*/
        srv.modifierpersonne(252, "nasriii");
        /* test d a'affichage user */
        srv.afficherpersonne(); 
        /* test d'afficher le nombre d'utlisateur selon le role*/
        int a = srv.NbUtilisateurRole("test1"); 
        System.out.println(a);
        
        
        /* test de réclamation */
        Reclamation rec = new Reclamation(); 
        ReclamationUser r1 = new ReclamationUser(5, 121, "test1", "test1", "test1", "test1"); 
        /* test ajout de reclamation */
        rec.ajouterReclamation(r1);
       /* test affichage reclamation*/
        rec.afficherReclamation();
        /* test de réussi */
        rec.modifierReclamation(5, "reussi test");
        /* test afficher réclamtion d'un id d 'utilisateur*/
        rec.afficherReclamationUser(252);
        /* test de suppression de reclamation*/
        rec.supprimerReclamation(33);
        /*test de réponse de réclamation*/
       ReponseReclamationAdmin rp = new  ReponseReclamationAdmin(); 
       rp.reponseReclamation(121, "traité", "traité");
       
       


      
        
       
    }    
}
