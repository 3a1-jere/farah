/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import java.sql.*;
import Entities.lignecommande ;
import DBConnection.connection;
import Entities.produits;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author farah
 */
 public class lignecommandeC {
         Connection c=connection.getInstance().getConn();
    
    public void ajouterLignecommande(lignecommande lcom)
    {
        try
        {
        Statement st=c.createStatement();
        String req="insert into lignecommande (id_commande,id_produit,Quantite_lignecommande) VALUES (?,?,?)";
        
         PreparedStatement ste=c.prepareStatement(req);
        ste.setInt(1, lcom.getId_commande());           
        ste.setInt(2, lcom.getId_produit());
            ste.setInt(3, lcom.getQuantite_lignecommande());

            
        ste.executeUpdate();
        
        }
        catch (SQLException ex) {
            System.out.println("Error sql : " + ex.getMessage());
        }
        
    }
    
    public ObservableList<lignecommande>  afficherLignecommande()
    {
        ObservableList<lignecommande> list = FXCollections.observableArrayList();
        try
        {
        Statement st=c.createStatement();
        String req1="select * from lignecommande";
        ResultSet rs=st.executeQuery(req1);
       while (rs.next()) {
                lignecommande lc = new lignecommande();
                lc.setId_commande(rs.getInt(1));
                lc.setId_produit(rs.getInt(2));
                lc.setQuantite_lignecommande(rs.getInt(3));
                list.add(lc);
            }
                   

            return list;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
    
    
    public void modifierLignecommande(lignecommande lcom)
    {
         try {
            PreparedStatement pt=c.prepareStatement("update lignecommande set Quantite_lignecommande=? where id_commande=?");
            pt.setInt(1, lcom.getQuantite_lignecommande());
            pt.setInt(2, lcom.getId_commande());
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lignecommandeC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


            public void supprimerLignecommande(lignecommande lcom)
    {
        try {
            PreparedStatement pt=c.prepareStatement("delete * from lignecommande  where id_commande=?");
            pt.setInt(1, lcom.getId_commande());
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lignecommandeC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


