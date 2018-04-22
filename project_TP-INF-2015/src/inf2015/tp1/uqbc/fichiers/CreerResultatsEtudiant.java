package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.CoursEtudiant;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static inf2015.tp1.uqbc.Utilitaires.FIN_LIGNE;
import static inf2015.tp1.uqbc.Utilitaires.REPERTOIRE_PAR_DEFAUT;
import static inf2015.tp1.uqbc.Utilitaires.SEP_FICHIER;


/**
 *
 * Classe qui permet d'ècrire le fichier txt par étudiant
 */
public class CreerResultatsEtudiant {

    private long version = 0l;

    public CreerResultatsEtudiant(long version){
        this.version = version;
    }
    
    /**
     * Cette méthode retourne la ligne qui affiche la version du document.
     * @return String la version
     */
    protected String getVersion(){
        return "Version : "+ new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(new Date(this.version)) +FIN_LIGNE;
    }
    
    
    /**
     * Cette méthode insère le texte qui doit être écrit dans le string et le retourne.
     * @param cours
     * @param etudiant
     * @return 
     */
    private String ecrireTexte(Cours cours, Etudiant etudiant) {
        String texte = null;
        String version = getVersion();
        CoursEtudiant coursEtudiant;
        double noteEtudiant = 0;
        texte = version + FIN_LIGNE;
        texte=texte
        + " * *****************************************************"+ FIN_LIGNE
        + " *                    RESULTAT ETUDIANT                *"+ FIN_LIGNE
        + " * *****************************************************"+ FIN_LIGNE+FIN_LIGNE;
        texte = texte + "                 ============================== " + FIN_LIGNE;
        texte = texte + "                 =   Code permanent : " + etudiant.getCodePermanent() + FIN_LIGNE;
        texte = texte + "                 =   Nom : " + etudiant.getNom() + FIN_LIGNE;
        texte = texte + "                 =   Prenom : " + etudiant.getPrenom() + FIN_LIGNE;
        texte = texte + "                 = ****************************"+FIN_LIGNE;
        texte = texte + "                 =   Cours: " + cours.getTitre() + cours.getNumeroCours() + FIN_LIGNE;
        texte = texte + "                 =   Groupe: " + cours.getGroupe()+ FIN_LIGNE;
        texte = texte + "                 =   Session: " + cours.getSession() + FIN_LIGNE;
        texte = texte + "                 ============================== " + FIN_LIGNE+ FIN_LIGNE;

        for (Evaluation evaluation : cours.getListeEvaluation()) {
            coursEtudiant = new CoursEtudiant(cours, etudiant, evaluation);
            texte = texte + "Evaluation " + coursEtudiant.getNumeroEvaluation() + " : ";
            texte = texte + coursEtudiant.getNomEvaluation() + FIN_LIGNE;
            texte = texte + "Type : " + coursEtudiant.getType() + FIN_LIGNE;
            texte = texte + "Ponderation : " + coursEtudiant.getPonderation() + FIN_LIGNE;
            texte = texte + "Note : " + coursEtudiant.getNote() + FIN_LIGNE;
            texte = texte + "Moyenne du groupe : " + coursEtudiant.getMoyenneGroupeEvaluation() + FIN_LIGNE;
            texte = texte + "============================ " + FIN_LIGNE;
            noteEtudiant = noteEtudiant + coursEtudiant.getNote();
        }
        texte = texte + "Total\r\n";
        texte = texte + "Ponderation : " + cours.getPonderationGroupe() + FIN_LIGNE;
        texte = texte + "Note : " + noteEtudiant + FIN_LIGNE;
        texte = texte + "Moyenne du groupe : " + cours.getMoyenneGroupe() + FIN_LIGNE;

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
            nomRepertoire = REPERTOIRE_PAR_DEFAUT + cours.getTitre();
            creerRepertoire(nomRepertoire);
            for (Etudiant etudiant : cours.getListeEtudiant()) {
                nomFichier = cours.getSession() + "_" + cours.getTitre() + "_" + etudiant.getCodePermanent();
                //on insere dans le fichier les données de l'objet CoursEtudiant
                texte = ecrireTexte(cours, etudiant);
                FileWriter writer = new FileWriter(nomRepertoire +SEP_FICHIER+ nomFichier + ".txt");
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
    public static Boolean creerRepertoire(String nomFichier) {
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
    public static Boolean creerFichier(String nomFichier) {

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
