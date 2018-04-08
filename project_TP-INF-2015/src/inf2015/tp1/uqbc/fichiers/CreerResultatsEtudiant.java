package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.CoursEtudiant;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * Classe qui permet d'ècrire le fichier txt par étudiant
 */
public class CreerResultatsEtudiant {

    private static final String defaultWorkingDirectory = "./";
    
    private String finLigne = System.lineSeparator();
    private String sepFichier = System.getProperty("file.separator");

    /**
     * Cette méthode insère le texte qui doit être écrit dans le string et le retourne.
     * @param cours
     * @param etudiant
     * @return 
     */
    private String ecrireTexte(Cours cours, Etudiant etudiant) {
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

    /**
     * Cette méthode écrit le fichier.
     * @param listeCours
     * @throws IOException 
     */
    public void ecrireFichier(List<Cours> listeCours) throws IOException {
        String nomFichier = null;
        String nomRepertoire = null;
        String texte = null;
        for (Cours cours : listeCours) {
            nomRepertoire = defaultWorkingDirectory + cours.getTitre();
            creerRepertoire(nomRepertoire);
            for (Etudiant etudiant : cours.getListeEtudiant()) {
                nomFichier = cours.getSession() + "_" + cours.getTitre() + "_" + etudiant.getCodePermanent();
                //on insere dans le fichier les données de l'objet CoursEtudiant
                texte = ecrireTexte(cours, etudiant);
                FileWriter writer = new FileWriter(nomRepertoire +sepFichier+ nomFichier + ".txt");
                writer.write(texte);
                writer.close();
            }
        }
    }

    /**
     * Cette méthode permet de créer le répertoire s'il n'existe pas.
     * @param nomFichier
     * @return 
     */
    private Boolean creerRepertoire(String nomFichier) {
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

    /**
     * Cette éthode permet de créer le fichier s'il n'existe pas.
     * @param nomFichier
     * @return 
     */
    private Boolean creerFichier(String nomFichier) {

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
