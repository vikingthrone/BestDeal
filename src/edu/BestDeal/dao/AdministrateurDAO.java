/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.BestDeal.dao;

import edu.BestDeal.entites.Administrateur;
import edu.BestDeal.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author yakoubi
 */
public class AdministrateurDAO {

    public void insertAdministrateur(Administrateur ad) {
        
             // AdministrateurDAO administrateurdao=new AdministrateurDAO();
                java.util.Date Date_de_naissance = new java.util.Date(90,01, 02);
                //year = year + 1900 
                //mois = mois + 1
                java.sql.Date sqlDate = new java.sql.Date(Date_de_naissance.getTime());
        String requete = "insert into Administrateur  (Nom,Prenom,e_mail,mot_de_passe,pseudo,CIN,Numero_Telephone,Date_de_naissance) values (?,?,?,?,?,?,?,?)";
               
        try {
            
            //Administrateur=Administrateurdao.findAdministrateurById(st.getAdministrateur().getId());
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, ad.getNom());
            ps.setString(2, ad.getPrenom());
            ps.setString(3, ad.getE_mail());
            ps.setString(4, ad.getMot_de_passe());
            ps.setString(5, ad.getPseudo());
            ps.setInt(6, ad.getCIN());
            ps.setInt(7, ad.getNumero_Telephone());
            ps.setDate(8,sqlDate );
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }

    }

    public void updateAdministrateur(Administrateur ad) {
        String requete = "update Administrateur set Nom=?,Prenom=?,e_mail=?,mot_de_passe=?,pseudo=?,Date_de_naissance=?,CIN=?,Numero_Telephone=?  where id=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, ad.getNom());
            ps.setString(2, ad.getPrenom());
            ps.setString(3, ad.getPseudo());
            ps.setString(4, ad.getE_mail());
            ps.setString(5, ad.getMot_de_passe());
            ps.setInt(6, ad.getCIN());
            ps.setInt(7, ad.getNumero_Telephone());
         //   ps.setDate(8, (java.sql.Date) ad.getDate_de_naissance());
            //ps.setString(9,ad.getImage_Profil());
            ps.setInt(10, ad.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(AdministrateurDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void deleteAdministrateur(int id) {
        String requete = "delete from pseudo where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Pseudo supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(AdministrateurDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Administrateur findAdministrateurById(int id) {
        Administrateur administrateur = new Administrateur();
        String requete = "select * from Administrateur where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                administrateur.setId(resultat.getInt(1));
                administrateur.setNom(resultat.getString(2));
                administrateur.setPrenom(resultat.getString(3));
                administrateur.setE_mail(resultat.getString(4));
                administrateur.setPseudo(resultat.getString(5));
                administrateur.setMot_de_passe(resultat.getString(6));
                //administrateur.setDate_de_naissance(resultat.getDate(7));
                administrateur.setCIN(resultat.getInt(8));
                administrateur.setNumero_Telephone(resultat.getInt(9));
//              administrateur.setImage_Profil(resultat.getImage(10));

            }
            return administrateur;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du administrateur " + ex.getMessage());
            return null;
        }
    }

    public Administrateur findaAdministrateurByNom(String nom) {
        Administrateur administrateur = new Administrateur();
        String requete = "select * from Administrateur where Nom = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                administrateur.setId(resultat.getInt(1));
                System.out.println(resultat.getString(1));
                administrateur.setNom(resultat.getString(2));
                System.out.println(resultat.getString(2));
                administrateur.setPrenom(resultat.getString(3));
                System.out.println(resultat.getString(3));
                administrateur.setE_mail(resultat.getString(4));
                System.out.println(resultat.getString(4));
                administrateur.setPseudo(resultat.getString(5));
                System.out.println(resultat.getString(5));
                administrateur.setMot_de_passe(resultat.getString(6));
                System.out.println(resultat.getString(6));
              //  administrateur.setDate_de_naissance(resultat.getDate(7));
                // System.out.println(resultat.getString(7));
                administrateur.setCIN(resultat.getInt(8));
                System.out.println(resultat.getString(8));
                administrateur.setNumero_Telephone(resultat.getInt(9));
                System.out.println(resultat.getString(9));
//              administrateur.setImage_Profil(resultat.getImage(10));
//              System.out.println(resultat.getString(10));
            }
            return administrateur;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du administrateur " + ex.getMessage());
            return null;
        }
    }

    public List<Administrateur> DisplayAllAdministrateurs() {

        List<Administrateur> listeAdministrateurs = new ArrayList<Administrateur>();

        String requete = "select * from Administrateur";
        try {
            Statement statement = MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Administrateur administrateur = new Administrateur();
                administrateur.setId(resultat.getInt(1));
                administrateur.setNom(resultat.getString(2));
                administrateur.setPrenom(resultat.getString(3));
                administrateur.setE_mail(resultat.getString(4));
                administrateur.setPseudo(resultat.getString(5));
                administrateur.setMot_de_passe(resultat.getString(6));
                // administrateur.setDate_de_naissance(resultat.getDate(7));
                administrateur.setCIN(resultat.getInt(8));
                administrateur.setNumero_Telephone(resultat.getInt(9));
//              administrateur.setImage_Profil(resultat.getImage(10));

                listeAdministrateurs.add(administrateur);
            }
            return listeAdministrateurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des administrateurs " + ex.getMessage());
            return null;
        }
    }

}
