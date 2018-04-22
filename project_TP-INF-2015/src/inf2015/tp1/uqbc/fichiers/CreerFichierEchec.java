/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.CoursEtudiant;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ValidationReussite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * Classe qui permet d'ècrire le fichier txt par étudiant
 */
public class CreerFichierEchec {

    private static final String repertoireParDefaut = "./";
    
    private String finLigne = System.lineSeparator();
    private String sepFichier = System.getProperty("file.separator");
    private long version = 0l;

    public CreerFichierEchec(long version){
        this.version = version;
    }
    
    /**
     * Cette méthode retourne la ligne qui affiche la version du document.
     * @return String la version
     */
    protected String getVersion(){
        return "Version : "+ new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(new Date(this.version)) +finLigne;
    }
    
    
    /**
     * Cette méthode insère le texte qui doit être écrit dans le string et le retourne.
     * @param cours
     * @param etudiant
     * @return 
     */
    private String ecrireTexte(Cours cours) {
        String texte = null;
        String version = getVersion();
        CoursEtudiant coursEtudiant;
        double noteEtudiant = 0;
        texte = version + finLigne;
        texte = texte + "Cours: " + cours.getTitre() + cours.getNumeroCours() + finLigne;
        texte = texte + "Groupe: " + cours.getGroupe() + finLigne;
        texte = texte + "Session: " + cours.getSession() + finLigne;
        texte = texte + "============================ " + finLigne;
  
for (Evaluation evaluation : cours.getListeEvaluation()) {
            texte = texte + "Code permanent : "  + finLigne;
            texte = texte + "Nom : "  + finLigne;
            texte = texte + "Prenom : "  + finLigne;
            texte = texte + "============================ " + finLigne;
            texte = texte + "Ponderation : " +finLigne;
            noteEtudiant = noteEtudiant ;
        }
        return texte;
    }

    public List<ValidationReussite> extraireEtudiantEchec(Cours cours){
        List<ValidationReussite>liste = new ArrayList();
        ValidationReussite validationReussite = new ValidationReussite();
        
        for(int i = 0; i >= cours.getListeEtudiant().size(); i++){
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
    public void ecrireFichier(List<Cours> listeCours) throws IOException {
        String nomFichier = null;
        String nomRepertoire = null;
        String texte = null;
        for (Cours cours : listeCours) {
            nomRepertoire = repertoireParDefaut + cours.getTitre();
            creerRepertoire(nomRepertoire);
                nomFichier = "Echec"+ "_"+cours.getSession() + "_" + cours.getTitre();
                //on insere dans le fichier les données de l'objet CoursEtudiant
                texte = ecrireTexte(cours);
                FileWriter writer = new FileWriter(nomRepertoire +sepFichier+ nomFichier + ".txt");
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

    

