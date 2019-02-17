/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import java.sql.*;
import Entities.livreur ;
import DBConnection.connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author farah
 */
 public class livreurC {

     Connection c=connection.getInstance().getConn();
    
    public void ajouterLivreur(livreur l)
    {
        try
        {
        Statement st=c.createStatement();
        String req="insert into livreur (id_livreur,Nom_livreur,Mail_livreur,Tel_livreur,Disponibilite) VALUES (?,?,?,?,?)";
        
         PreparedStatement ste=c.prepareStatement(req);
        ste.setInt(1, l.getId_livreur());           
        ste.setString(2, l.getNom_livreur());
            ste.setString(3, l.getMail_livreur());
            ste.setString(4, l.getTel_livreur());
            ste.setString(5, l.getDisponibilite());
            
        ste.executeUpdate();
        
        }
        catch (SQLException ex) {
            System.out.println("Error sql : " + ex.getMessage());
        }
        
    }
    
    public ObservableList<livreur> afficherLivreur()
        
    {
        ObservableList<livreur> list = FXCollections.observableArrayList();
        try
        {
        Statement st=c.createStatement();
        String req1="select * from livreur";
        ResultSet rs=st.executeQuery(req1);
                   while (rs.next()) {
                livreur l = new livreur();
                l.setId_livreur(rs.getInt(1));
                l.setNom_livreur(rs.getString(2));
                l.setMail_livreur(rs.getString(3));
                l.setTel_livreur(rs.getString(4));
                l.setDisponibilite(rs.getString(5));
                list.add(l);
            }
                   

            return list;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
    
    
   public void modifierLivreur(livreur l)
    {
        try {
            PreparedStatement pt=c.prepareStatement("update livreur set Nom_livreur=?,Mail_livreur=?,Tel_livreur=?,Disponibilite=? where id_livreur=?");
            
            pt.setString(1, l.getNom_livreur());
            pt.setString(2, l.getMail_livreur());
            pt.setString(3, l.getTel_livreur());
            pt.setString(4, l.getDisponibilite());
            pt.setInt(5, l.getId_livreur());
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(livreurC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void supprimerLivreur(int id)
    {

        try {
            Statement pt = c.createStatement();
            String req = "delete from livreur where id_livreur=" + id;
            pt.executeUpdate(req);
            System.out.println("suppression ok");

        } catch (SQLException ex) {
            Logger.getLogger(livreurC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


    
