package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Class qui s'occupe de la création du fichier
 * @author benoit
 */
public class CreerResultatsGroupeCours {
    
    private static final String repertoireParDefaut = "./";
    
    private String finLigne = System.lineSeparator();
    private String sepFichier = System.getProperty("file.separator");
    private long version = 0l;    
    
    /**
     * 	1.	Un fichier par groupe-cours, en format TXT;
	2.	Contient toutes les évaluations compilées pour le groupe-cours; 
	3.	Présente pour chaque évaluation la moyenne, le mode, la médiane, l’écart-type et le nombre d ‘étudiants;
	4.	Le fichier peut être regénéré au besoin, si l’enseignant a fait des changements;
	5.	Le cours doit être identifié par son sigle;
	6.	Le groupe-cours doit être identifié par son numéro;
	7.	Le fichier est versionné avec la date et l’heure pour s’y retrouver parmi les multiples versions;
     * @param listeCours 
     */
    public void ecrireFichier(List<Cours> listeCours){
        
        
        //Creer nouveau fichier pour chaque cours
        for(Cours cours : listeCours){
            
            StringBuilder sbTexte = new StringBuilder();
            String nomRepertoire = repertoireParDefaut + cours.getTitre();
            
            creerRepertoire(nomRepertoire);
            
            String szGroupeCours = cours.getGroupe()+"-"+cours.getTitre()+"-"+cours.getNumeroCours();
            
            sbTexte.append("Groupe - Cours :"+szGroupeCours+finLigne);
            sbTexte.append("Session:"+cours.getSession());
            
            String nomFichier = szGroupeCours+".txt";

//2.	Contient toutes les évaluations compilées pour le groupe-cours; 
//3.	Présente pour chaque évaluation la moyenne, le mode, la médiane, l’écart-type et le nombre d ‘étudiants; 
            for(Evaluation evaluation : cours.getListeEvaluation()){               

                sbTexte.append("Evaluation : "+evaluation.getNomEvaluation()+"-"+evaluation.getNumeroEvaluation()+finLigne+finLigne);
                
                sbTexte.append("Moyenne : "+Calculs.calculMoyenne(evaluation)+finLigne);
                sbTexte.append("Mode : "+Calculs.calculMode(evaluation)+finLigne);
                sbTexte.append("Médiane : "+Calculs.calculMediane(evaluation)+finLigne);
                sbTexte.append("Écart-type : "+Calculs.calculEcartType(evaluation)+finLigne);
                sbTexte.append("Nombre d'étudiant : "+cours.getListeEtudiant().size()+finLigne+finLigne+finLigne);
               
                
                try (FileWriter writer = new FileWriter(nomRepertoire +sepFichier+ nomFichier )) {
                    writer.write(sbTexte.toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                

            }
            

//            Calculs.calculMoyenneGroupeEvaluation(listeResultatEvaluation);
//            Calculs.calculMoyenneGroupeGlobale(listeEtudiant, listeEvaluation);
//            Calculs.calculNbreEtudiants(evaluation);
//            Calculs.calculNotePondereeEvaluation(listeEtudiant, listeEvaluation, codeParmanent, numeroEvaluation);
//            Calculs.calculNotePondereeGlobale(listeEtudiant, listeEvaluation, codeParmanent);
//            Calculs.calculPonderationGlobaleEtudiant(listeEtudiant, listeEvaluation, codeParmanent);
//            Calculs.calculPonderationGroupeGlobale(listeEtudiant, listeEvaluation);
  
            
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
                se.printStackTrace();
            }
        }
        return fichierExiste;
    }
    
    /**
     * Cette méthode insère le texte qui doit être écrit dans le string et le retourne.
     * @param cours
     * @param etudiant
     * @return 
     */
    private String ecrireTexte(Cours cours, Evaluation evaluation) {
        
        StringBuilder sb = new StringBuilder();
        String texte = null;
        String version = getVersion();
        
        
        
        return texte;
    }
    
    
    /**
     * Cette méthode retourne la ligne qui affiche la version du document.
     * @return String la version
     */
    protected String getVersion(){
        return "Version : "+ new SimpleDateFormat().format(new Date(this.version)) +finLigne;
    }    
    
}
