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
import java.util.ArrayList;
import java.util.List;
import models.User;
import technique.ConnectionUtil;





/**
 * @author Nasri
 */
public class ServiceUser 
{

    PreparedStatement preparedStatement;
    Connection connection;
    public ServiceUser()
    {
        connection = (Connection) ConnectionUtil.conDB();
    }
    

   /* fonctionne*/
    public void ajouterpersonne(User p)
    {
        try 
        {
            
             
            String st = "INSERT INTO user ( id, nom, prenom) VALUES (?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(st);
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setString(2, p.getNom());
            preparedStatement.setString(3, p.getPrenom());
            preparedStatement.executeUpdate();
          

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
   }
    
      public void ajouterpersonne1(User p)
    {
        try {
            
            String req="insert into user values (nom,prenom)VALUES (?,?)"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            preparedStatement.setString(1, p.getNom()); 
            preparedStatement.setString(2, p.getPrenom());
            preparedStatement.executeUpdate();

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
   }
     
   

       public void modifierpersonne(int id, String nom)
    {
        try {
            
            String req="update user set nom =? where id=?"; 
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
   public void supprimerpersonne(int id)
    {
        try {
            
            String req="delete from user where id=?"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
   }
       

  
   public void afficherpersonne()
   {
        try {
            List<User> ls =new ArrayList<User>();
            String req="select * from user"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            ResultSet rs = connection.createStatement().executeQuery(req);

            
       
            
            while(rs.next()){
                
                User p = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                ls.add(p);
            }
            
            for (User p : ls){
                System.out.println(p.toString());
            }
        } catch (SQLException ex)
        {
             System.out.println(ex.getMessage());

        }
        
    }
   /* retourner le noombre d'utlisateur*/
     public int NbUtilisateurRole(String role)
   {
        try {
            
            String req="select * from reclamation where role=? "; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);

     
            preparedStatement.setString(1, role);
            preparedStatement.executeQuery();
           return    preparedStatement.getMaxRows(); 

           
                       

        } 
        catch (SQLException ex) 
        {
             System.out.println(ex.getMessage());

        }
        return  0; 
        
   
    }
     /* afficher la liste d'utlisateur selon role */
     public void afficherpersonneRoel( String role)
   {
        try {
            List<User> ls =new ArrayList<User>();
            String req="select * from user where role=?"; 
            preparedStatement = (PreparedStatement) connection.prepareStatement(req);
            preparedStatement.setString(1, role);

            ResultSet rs = connection.createStatement().executeQuery(req);

            
       
            
            while(rs.next()){
                
                User p = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                ls.add(p);
            }
            
            for (User p : ls){
                System.out.println(p.toString());
            }
        } catch (SQLException ex)
        {
             System.out.println(ex.getMessage());

        }
        
    }
    
   
        
 
   
    
    
}
