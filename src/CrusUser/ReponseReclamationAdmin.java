/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrusUser;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import models.ReclamationUser;
import technique.ConnectionUtil;

/**
 *
 * @author Nasri
 */
public class ReponseReclamationAdmin 
{
    PreparedStatement preparedStatement;
    Connection connection;    
    public ReponseReclamationAdmin()
    {
         connection = (Connection) ConnectionUtil.conDB();

    }
    
    
     public void reponseReclamation(int id, String etat , String reponse  )
             
        {
            try 
            {

                String req="update reclamation set etat =? ,reponse=?  where id=?"; 
                preparedStatement = (PreparedStatement) connection.prepareStatement(req);

                preparedStatement.setString(1, etat);
                preparedStatement.setString(2, reponse);
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();

            } 
            catch (SQLException ex) 
            {
                 System.out.println(ex.getMessage());

            }
       }
    
}
