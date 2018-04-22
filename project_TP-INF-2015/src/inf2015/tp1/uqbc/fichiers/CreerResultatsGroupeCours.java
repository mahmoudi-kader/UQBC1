package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.Utilitaires;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static inf2015.tp1.uqbc.Utilitaires.FIN_LIGNE;
import static inf2015.tp1.uqbc.Utilitaires.REPERTOIRE_PAR_DEFAUT;
import static inf2015.tp1.uqbc.Utilitaires.SEP_FICHIER;
/**
 *  Class qui s'occupe de la création du fichier
 * @author benoit
 */
public class CreerResultatsGroupeCours {
    
    
    /**
     * Cette méthode créé le fichier de résultats pour le group- cours passé en paramettre,
     * selon les critères suivants:
     * 
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
        
        String texte="";
         texte=texte+
       " * *****************************************************"+ FIN_LIGNE
     + " *               RESULTATS DU GROUPE COURS             *"+ FIN_LIGNE
     + " * *****************************************************"+ FIN_LIGNE+FIN_LIGNE;
        //Creer nouveau fichier pour chaque cours
        for(Cours cours : listeCours){
            StringBuilder sbTexte = new StringBuilder();
            sbTexte.append(texte);
            sbTexte.append(Utilitaires.getInstance().getVersion());
            String szGroupeCours = cours.getGroupe()+"-"+cours.getTitre();
            sbTexte.append("        Groupe-Cours : ").append(szGroupeCours);
            sbTexte.append("        Session : ").append(cours.getSession()).append(FIN_LIGNE).append(FIN_LIGNE).append(FIN_LIGNE);
            String nomRepertoire = REPERTOIRE_PAR_DEFAUT + cours.getTitre();
            creerRepertoire(nomRepertoire);
            String nomFichier = szGroupeCours+".txt";

            for(Evaluation evaluation : cours.getListeEvaluation()){               

                sbTexte.append("Evaluation : "+evaluation.getNomEvaluation()+"-"+evaluation.getNumeroEvaluation()+FIN_LIGNE+FIN_LIGNE);
                sbTexte.append("Moyenne : "+Calculs.calculMoyenne(evaluation)+FIN_LIGNE);
                sbTexte.append("Mode : "+Calculs.calculMode(evaluation)+FIN_LIGNE);
                sbTexte.append("Médiane : "+Calculs.calculMediane(evaluation)+FIN_LIGNE);
                sbTexte.append("Écart-type : "+Calculs.calculEcartType(evaluation)+FIN_LIGNE);
                sbTexte.append("Nombre d'étudiant : "+cours.getListeEtudiant().size()+FIN_LIGNE+FIN_LIGNE+FIN_LIGNE);
               
                
                try (FileWriter writer = new FileWriter(nomRepertoire +SEP_FICHIER+ nomFichier )) {
                    writer.write(sbTexte.toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
        String version = Utilitaires.getInstance().getVersion();

        return texte;
    }
       
    
}
