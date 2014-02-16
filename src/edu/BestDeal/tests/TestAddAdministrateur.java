/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.BestDeal.tests;

import edu.BestDeal.dao.AdministrateurDAO;
import edu.BestDeal.entites.Administrateur;

/**
 *
 * @author yakoubi
 */
public class TestAddAdministrateur {

    public static void main(String[] args) {
                java.util.Date Date_de_naissance = new java.util.Date(90,01, 02);
                //year = year + 1900 
                 //mois = mois + 1
                java.sql.Date sqlDate = new java.sql.Date(Date_de_naissance.getTime());

        Administrateur administrateur = new Administrateur();
        AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        administrateur.setNom("yakoubi");
        administrateur.setPrenom("mohammed");
        administrateur.setE_mail("yakoubi_mohammed@hotmail.fr");
        administrateur.setMot_de_passe("23536534m");
        administrateur.setPseudo("yak");
        administrateur.setCIN(11853171);
        administrateur.setNumero_Telephone(23536534);
        administrateur.setDate_de_naissance(Date_de_naissance);
        //  administrateur.setimage(null);
        administrateurDAO.insertAdministrateur(administrateur);
    }

}
