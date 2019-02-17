/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import java.sql.*;
import Entities.produits ;
import DBConnection.connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author farah
 */
 public class produitC {

     Connection c=connection.getInstance().getConn();
    
   
    public ObservableList<produits> afficherProduits()
        
    {
        ObservableList<produits> list = FXCollections.observableArrayList();
        try
        {
        Statement st=c.createStatement();
        String req1="select * from produits";
        ResultSet rs=st.executeQuery(req1);
                   while (rs.next()) {
                produits p = new produits();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrix(rs.getFloat(3));
                p.setQuantite(rs.getInt(4));
                p.setImage(rs.getString(5));
                list.add(p);
            }
                   

            return list;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
       
}


    
