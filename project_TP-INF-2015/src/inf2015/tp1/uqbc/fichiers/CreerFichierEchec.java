package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.CoursEtudiant;
import inf2015.tp1.uqbc.Utilitaires;
import inf2015.tp1.uqbc.validation.ValidationReussite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static inf2015.tp1.uqbc.Utilitaires.FIN_LIGNE;
import static inf2015.tp1.uqbc.Utilitaires.REPERTOIRE_PAR_DEFAUT;
import static inf2015.tp1.uqbc.Utilitaires.SEP_FICHIER;

/**
 *
 * Classe qui permet d'écrire le fichier txt par étudiant
 */
public class CreerFichierEchec {
    /**
     * Cette méthode insère le texte qui doit être écrit dans le string et le retourne.
     * @param cours
     * @param etudiant
     * @return 
     */
    private String ecrireTexte(Cours cours) {
        String texte = null;
 
        CoursEtudiant coursEtudiant;
        double noteEtudiant = 0;
        List<ValidationReussite>liste = new ArrayList();
        liste=extraireEtudiantEchec(cours);
        texte = Utilitaires.getInstance().getVersion() + FIN_LIGNE;
         texte+=" * *****************************************************"+ FIN_LIGNE
     + " *               ETUDIANTS EN SITUATION D'ECHEC        *"+ FIN_LIGNE
     + " * *****************************************************"+ FIN_LIGNE+FIN_LIGNE;
        texte = texte + "                 ============================ " + FIN_LIGNE;
        texte = texte + "                 =   Cours: " + cours.getTitre() + cours.getNumeroCours() + FIN_LIGNE;
        texte = texte + "                 =   Groupe: " + cours.getGroupe() + FIN_LIGNE;
        texte = texte + "                 =   Session: " + cours.getSession() + FIN_LIGNE;
        texte = texte + "                 ============================ " + FIN_LIGNE+ FIN_LIGNE+ FIN_LIGNE;

        for (ValidationReussite validation : liste) {
            
            texte = texte + "Code permanent : " +validation.getEtudiant().getCodePermanent() + FIN_LIGNE;
            texte = texte + "Nom : " +validation.getEtudiant().getNom() + FIN_LIGNE;
            texte = texte + "Prenom : " +validation.getEtudiant().getPrenom() + FIN_LIGNE;
            texte = texte + "Note : " +validation.getNote()+FIN_LIGNE;
            texte = texte + "Ponderation : " +validation.getPonderation()+FIN_LIGNE;
            texte = texte + "Pourcentage Reussite : " +validation.getPourcentageReussite()+FIN_LIGNE;
            texte = texte + "============================ " + FIN_LIGNE;

        }
        return texte;
    }

    public List<ValidationReussite> extraireEtudiantEchec(Cours cours){
        List<ValidationReussite>liste = new ArrayList();
        ValidationReussite validationReussite = new ValidationReussite();
        
        for(int i = 0; i < cours.getListeEtudiant().size(); i++){
            validationReussite = new ValidationReussite(cours,cours.getListeEtudiant().get(i));
            if(validationReussite.getPourcentageReussite()<60){
                liste.add(validationReussite);
            }
        }
        return liste;
    }
    
    /**
     * Cette méthode écrit le fichier.
     * @param listeCours
     * @throws IOException 
     */
    public  void ecrireFichier(List<Cours> listeCours) throws IOException {
        String nomFichier = null;
        String nomRepertoire = null;
        String texte = null;
        for (Cours cours : listeCours) {
            nomRepertoire = REPERTOIRE_PAR_DEFAUT + cours.getTitre();
            creerRepertoire(nomRepertoire);
                nomFichier = "Echec"+ "_"+cours.getSession() + "_" + cours.getTitre();
                texte = ecrireTexte(cours);
                FileWriter writer = new FileWriter(nomRepertoire +SEP_FICHIER+ nomFichier + ".txt");
                writer.write(texte);
                writer.close();
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

    

