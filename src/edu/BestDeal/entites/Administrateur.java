/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.BestDeal.entites;

import java.util.Date;

/**
 *
 * @author yakoubi
 */
public class Administrateur {
    private int Id;
    private String Nom ; 
    private String Prenom ; 
    private String e_mail;
    private String mot_de_passe;
    private String pseudo;
    private Date Date_de_naissance;
    private int CIN ;
    private int Numero_Telephone;
   // private String Image ;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Date getDate_de_naissance() {
        return Date_de_naissance;
    }

    public void setDate_de_naissance(Date Date_de_naissance) {
        this.Date_de_naissance = Date_de_naissance;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public int getNumero_Telephone() {
        return Numero_Telephone;
    }

    public void setNumero_Telephone(int Numero_Telephone) {
        this.Numero_Telephone = Numero_Telephone;
    }

//    public String getImage() {
//        return Image;
//    }
//
//    public void setImage(String Image) {
//        this.Image = Image;
//    }

   
    
    
}
