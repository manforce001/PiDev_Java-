/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudUser;

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
  public void ajouterReclamation( User p )
    {
        try 
        {
            Statement st = connection.createStatement();
            String req="insert into reclamation values ("+p.getId()+", '"+p.getId()+"', '"+p.getPrenom()+"')";
            st.executeUpdate(req);
        } catch (SQLException ex) 
        {
            System.out.println(ex.toString());
           
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
    public void modifierReclamation(int id, String nom)
    {
        try {
            
            String req="update reclamation set nom =? where id=?"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            preparedStatement.setString(1, nom);
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
                
                ReclamationUser p = new ReclamationUser(rs.getInt(1), rs.getInt(2), rs.getString(3));
             
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
        try {
            
            List<ReclamationUser> ls =new ArrayList<ReclamationUser>();
            String req="select * from reclamation where id_user=? "; 
            preparedStatement.setInt(1, id_user);
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            ResultSet rs = connection.createStatement().executeQuery(req);
            while(rs.next()){
                
                ReclamationUser p = new ReclamationUser(rs.getInt(1), rs.getInt(2), rs.getString(3));
             
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
       
       
       
   
    
   
    
}
