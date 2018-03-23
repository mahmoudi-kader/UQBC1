package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.CoursEtudiant;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ResultatEvaluation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe qui permet d'ècrire le fichier txt par étudiant
 */
public class CreerDocument {
    private static final String defaultWorkingDirectory = "./";
    
    private String EcrireTexte(Cours cours, Etudiant etudiant) {
        String texte = null;
        String version = "Version :      a venir       \r\n";
        CoursEtudiant coursEtudiant;
        double noteEtudiant = 0;
        texte = version + "\r\n";
        texte = texte + "Cours: " + cours.getTitre() + cours.getNumeroCours() + "\r\n";
        texte = texte + "Groupe: " + cours.getGroupe() + "\r\n";
        texte = texte + "Session: " + cours.getSession() + "\r\n";
        texte = texte + "============================ " + "\r\n";
        texte = texte + "Cours : " + etudiant.getCodePermanent() + "\r\n";
        texte = texte + "Groupe: " + etudiant.getNom() + "\r\n";
        texte = texte + "Session: " + etudiant.getPrenom() + "\r\n";
        texte = texte + "============================ " + "\r\n";
        for(Evaluation evaluation : cours.getListeEvaluation()){
            coursEtudiant = new CoursEtudiant(cours, etudiant, evaluation);
            texte = texte + "Evaluation " + coursEtudiant.getNumeroEvaluation() + " : ";
            texte = texte + coursEtudiant.getNomEvaluation() +  "\r\n";
            texte = texte + "Type : " + coursEtudiant.getType() +  "\r\n";
            texte = texte + "Ponderation : " + coursEtudiant.getPonderation() +  "\r\n";
            texte = texte + "Note : " + coursEtudiant.getNote() +  "\r\n";
            texte = texte + "Moyenne du groupe : " + coursEtudiant.getMoyenneGroupeEvaluation() +  "\r\n";
            texte = texte + "============================ " + "\r\n";
            noteEtudiant = noteEtudiant + coursEtudiant.getNote();
        }
        texte = texte + "Total\r\n";
        texte = texte + "Ponderation : " + cours.getPonderationGroupe() + "\r\n";
        texte = texte + "Note : " + noteEtudiant + "\r\n";
        texte = texte + "Moyenne du groupe : " + cours.getMoyenneGroupe() + "\r\n";
        
        return texte;
    }

    public void EcrireFichier(List<Cours> listeCours) throws IOException {
        String nomFichier = null;
        String nomRepertoire = null;
        String texte = null;
        for (Cours cours : listeCours) {
            nomRepertoire = defaultWorkingDirectory + cours.getTitre() + cours.getNumeroCours() + "\\";
            CreerRepertoire(nomRepertoire);
            for (Etudiant etudiant : cours.getListeEtudiant()) {
                nomFichier = cours.getSession() + "_" + cours.getTitre() + cours.getNumeroCours() + "_" + etudiant.getCodePermanent();
                CreerFichier(nomRepertoire + nomFichier + ".txt");
                //on insere dans le fichier les données de l'objet CoursEtudiant
                texte = EcrireTexte(cours, etudiant);
                //BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
                FileWriter writer = new FileWriter(nomRepertoire + nomFichier + ".txt");
                writer.write(texte);
                writer.close();
            }
        }
    }

    private Boolean CreerRepertoire(String nomFichier) {
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

    private Boolean CreerFichier(String nomFichier) {

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
