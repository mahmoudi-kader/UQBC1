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
    
    private String finLigne = System.lineSeparator();
    private String sepFichier = System.getProperty("file.separator");

    private String EcrireTexte(Cours cours, Etudiant etudiant) {
        String texte = null;
        String version = "Version :      a venir       "+finLigne;
        CoursEtudiant coursEtudiant;
        double noteEtudiant = 0;
        texte = version + finLigne;
        texte = texte + "Cours: " + cours.getTitre() + cours.getNumeroCours() + finLigne;
        texte = texte + "Groupe: " + cours.getGroupe() + finLigne;
        texte = texte + "Session: " + cours.getSession() + finLigne;
        texte = texte + "============================ " + finLigne;
        texte = texte + "Code permanent : " + etudiant.getCodePermanent() + finLigne;
        texte = texte + "Nom : " + etudiant.getNom() + finLigne;
        texte = texte + "Prenom : " + etudiant.getPrenom() + finLigne;
        texte = texte + "============================ " + finLigne;
        for (Evaluation evaluation : cours.getListeEvaluation()) {
            coursEtudiant = new CoursEtudiant(cours, etudiant, evaluation);
            texte = texte + "Evaluation " + coursEtudiant.getNumeroEvaluation() + " : ";
            texte = texte + coursEtudiant.getNomEvaluation() + finLigne;
            texte = texte + "Type : " + coursEtudiant.getType() + finLigne;
            texte = texte + "Ponderation : " + coursEtudiant.getPonderation() + finLigne;
            texte = texte + "Note : " + coursEtudiant.getNote() + finLigne;
            texte = texte + "Moyenne du groupe : " + coursEtudiant.getMoyenneGroupeEvaluation() + finLigne;
            texte = texte + "============================ " + finLigne;
            noteEtudiant = noteEtudiant + coursEtudiant.getNote();
        }
        texte = texte + "Total\r\n";
        texte = texte + "Ponderation : " + cours.getPonderationGroupe() + finLigne;
        texte = texte + "Note : " + noteEtudiant + finLigne;
        texte = texte + "Moyenne du groupe : " + cours.getMoyenneGroupe() + finLigne;

        return texte;
    }

    public void EcrireFichier(List<Cours> listeCours) throws IOException {
        String nomFichier = null;
        String nomRepertoire = null;
        String texte = null;
        for (Cours cours : listeCours) {
            nomRepertoire = defaultWorkingDirectory + cours.getTitre();
            CreerRepertoire(nomRepertoire);
            for (Etudiant etudiant : cours.getListeEtudiant()) {
                nomFichier = cours.getSession() + "_" + cours.getTitre() + "_" + etudiant.getCodePermanent();
                //CreerFichier(nomRepertoire + sepFichier +nomFichier + ".txt");
                //on insere dans le fichier les données de l'objet CoursEtudiant
                texte = EcrireTexte(cours, etudiant);
                //BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
                FileWriter writer = new FileWriter(nomRepertoire +sepFichier+ nomFichier + ".txt");
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
