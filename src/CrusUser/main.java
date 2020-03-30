/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrusUser;

import models.User;

/**
 *
 * @author Nasri
 */
public class main {
     public static void main(String[] args) {

        /*       A a1 = A.getInstance();
         A a2 = A.getInstance();

         System.out.println("hashcode de a1 :" + a1.hashCode());
         System.out.println("hashcode de a2 :" + a2.hashCode());
         */
         User p1 = new User(225, "hhh", "hhh"); 

        ServiceUser srv = new ServiceUser();


         System.out.println("insertion ");
        // srv.ajouterpersonne(p1);
    
    }

    
}
