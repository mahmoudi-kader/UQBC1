/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.CoursEtudiant;
import inf2015.tp1.uqbc.Etudiant;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Abdelkader
 */
public class CreerDocument {

    public String EcrireTexte(Cours cours, Etudiant etudiant) {
        String texte = null;
        String version = "Version :      a venir       ";
        CoursEtudiant coursEtudiant = new CoursEtudiant();
        coursEtudiant.setCours(cours);
        coursEtudiant.setEtudiant(etudiant);
        texte = version + "/n";
        texte = texte + "Cours: " + cours.getTitre() + cours.getNumeroCours() + "/n";
        texte = texte + "Groupe: " + cours.getGroupe() + "/n";
        texte = texte + "Session: " + cours.getSession() + "/n";
        texte = texte + "============================ " + "/n";
        texte = texte + "Cours : " + etudiant.getCodePermanent() + "/n";
        texte = texte + "Groupe: " + etudiant.getNom() + "/n";
        texte = texte + "Session: " + etudiant.getPrenom() + "/n";
        texte = texte + "============================ " + "/n";
        texte = texte + "Evaluation: " + "/n";
        texte = texte + "/n";
        texte = texte +  "/n";
        texte = texte + "============================ " + "/n";

        return texte;
    }

    public void EcrireFichier(List<Cours> listeCours) throws IOException {
        String nomFichier = null;
        String nomRepertoire = null;
        String texte = null;
        for (Cours cours : listeCours) {
            nomRepertoire = cours.getTitre() + cours.getNumeroCours();
            CreerRepertoire(nomRepertoire);
            for (Etudiant etudiant : cours.getListeEtudiant()) {
                nomFichier = cours.getSession() + "_" + cours.getTitre() + cours.getNumeroCours() + "_" + etudiant.getCodePermanent();
                CreerFichier(nomFichier);
                //on insere dans le fichier les données de l'objet CoursEtudiant

                FileWriter writer = new FileWriter(nomFichier);
                writer.write(texte);
                writer.close();
            }
        }
    }

    public Boolean CreerRepertoire(String nomFichier) {
        File theDir = new File(nomFichier);
        boolean result = false;
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {

            }
        }
        return result;
    }

    public Boolean CreerFichier(String nomFichier) {

        File fichier = new File(nomFichier);
        boolean fichierExiste = false;
        fichierExiste = fichier.exists();
        if (!fichierExiste) {
            try {
                fichier.createNewFile();
                fichierExiste = true;
            } catch (Exception se) {
            }
        }
        return fichierExiste;
    }
}
