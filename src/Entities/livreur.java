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
public class livreur {
        private int id_livreur;
    private String Nom_livreur;
    private String Mail_livreur;
    private String Tel_livreur;
    private String Disponibilite;
    
        public livreur(){
        
    }

    public livreur(int id_livreur, String Nom_livreur, String Mail_livreur, String Tel_livreur,String Disponibilite ) {
        this.id_livreur = id_livreur;
        this.Nom_livreur = Nom_livreur;
        this.Mail_livreur = Mail_livreur;
        this.Tel_livreur = Tel_livreur;
        this.Disponibilite = Disponibilite;
    }

      public int getId_livreur() {
        return id_livreur;
    }

    public String getNom_livreur() {
        return Nom_livreur;
    }

    public String getMail_livreur() {
        return Mail_livreur;
    }

    public String getTel_livreur() {
        return Tel_livreur;
    }

    public String getDisponibilite() {
        return Disponibilite;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public void setNom_livreur(String Nom_livreur) {
        this.Nom_livreur = Nom_livreur;
    }

    public void setMail_livreur(String Mail_livreur) {
        this.Mail_livreur = Mail_livreur;
    }

    public void setTel_livreur(String Tel_livreur) {
        this.Tel_livreur = Tel_livreur;
    }

    public void setDisponibilite(String Disponibilite) {
        this.Disponibilite = Disponibilite;
    }




    
    
    
}
