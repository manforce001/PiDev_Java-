/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrusUser;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ReclamationUser;
import models.User;
import technique.ConnectionUtil;

/**
 *
 * @author Nasri
 */
public class Reclamation 
{
    PreparedStatement preparedStatement;
    Connection connection;
    public Reclamation()
    {
                connection = (Connection) ConnectionUtil.conDB();

    }
 
     public void ajouterReclamation(ReclamationUser p)
    {
        try 
        {   
            String st = "INSERT INTO reclamation ( id, id_user, sujet,reclamation ,etat,reponse  ) VALUES (?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(st);
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setInt(2, p.getId_user());
            preparedStatement.setString(3, p.getSujet());
            preparedStatement.setString(4, p.getReclamation());
            preparedStatement.setString(5, p.getEtat());
            preparedStatement.setString(6, p.getReclamation());

            
            preparedStatement.executeUpdate();
         } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
   }
  public void supprimerReclamation(int id)
    {
        try 
        {
            
            String req="delete from reclamation where id=?"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
   }
    public void modifierReclamation(int id, String reclamation)
    {
        try {
            
            String req="update reclamation set reclamation =? where id=?"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            preparedStatement.setString(1, reclamation);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
   }
    /* afficher la liste de tout les reclamation*/
   public void afficherReclamation()
   {
        try {
            
            List<ReclamationUser> ls =new ArrayList<ReclamationUser>();
            String req="select * from reclamation"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            ResultSet rs = connection.createStatement().executeQuery(req);

            
       
            
            while(rs.next()){
                
                ReclamationUser p = new ReclamationUser(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
             
                ls.add(p);
            }
            
            for (ReclamationUser p : ls)
            {
                System.out.println(p.toString());
            }
        } catch (SQLException ex)
        {
             System.out.println(ex.getMessage());

        }
        
    }
   /* recherhce reclamation par l'id de reclamtion*/
     public boolean rechercheReclamation(int id)
    {
        try {
            
            String req="select * from reclamation where id=? "; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);

     
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            if (preparedStatement.getMaxRows()==0)
            {
               return false; 
                       
            }
                       

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
        
        return true; 
   
    }
     /* recherche reclamatation de l'utlisateur  donnée */
       public boolean rechercheReclamationUser(int id)
    {
        try {
            
            String req="select * from reclamation where id_user=? "; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);

     
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            if (preparedStatement.getMaxRows()==0)
            {
               return false; 
                       
            }
                       

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
        
        return true; 
   
    }
       /* retourner la liste de reclamation d'un utlisateur donnée*/        
        public void afficherReclamationUser(int id_user )
   {
                   List<ReclamationUser> ls =new ArrayList<ReclamationUser>();

        try {
            
            String req="select * from reclamation "; 
            preparedStatement.setInt(1, id_user);
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            ResultSet rs = connection.createStatement().executeQuery(req);
            while(rs.next()){
                
                ReclamationUser p = new ReclamationUser(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5) , rs.getString(6));
                if (rs.getInt(2)==id_user)
                {
                            ls.add(p);

                }
            }
            
            for (ReclamationUser p : ls)
            {
                System.out.println(p.toString());
            }
        } catch (SQLException ex)
        {
             System.out.println(ex.getMessage());

        }
        
    }
       
       
       
   
    
   
    
}
