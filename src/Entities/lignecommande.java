/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author farah
 */
public class lignecommande {
   
    private int id_commande;
    private int id_produit;
    private int Quantite_lignecommande;
    //private float Total_produit;

    public lignecommande( int id_produit, int Quantite_lignecommande) {

        //this.id_commande=id_commande;
        this.id_produit = id_produit;
        this.Quantite_lignecommande = Quantite_lignecommande;
        
    }

    public lignecommande() {
        
    }

    public int getId_commande() {
        return id_commande;
    }

 

    public int getId_produit() {
        return id_produit;
    }

    public int getQuantite_lignecommande() {
        return Quantite_lignecommande;
    }

  

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

 
    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setQuantite_lignecommande(int Quantite_lignecommande) {
        this.Quantite_lignecommande = Quantite_lignecommande;
    }

  /*  public void setTotal_produit(float Total_produit) {
        this.Total_produit = Total_produit;
    }
*/
   
}
