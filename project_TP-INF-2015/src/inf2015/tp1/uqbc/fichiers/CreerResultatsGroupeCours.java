package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Evaluation;
import java.util.List;

/**
 *  Class qui s'occupe de la création du fichier
 * @author benoit
 */
public class CreerResultatsGroupeCours {
    
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
        
        for(Cours cours : listeCours){
            
            
            //Creer nouveau fichier pour chaque cours
            cours.getGroupe();
//2.	Contient toutes les évaluations compilées pour le groupe-cours; 
//3.	Présente pour chaque évaluation la moyenne, le mode, la médiane, l’écart-type et le nombre d ‘étudiants; 
            for(Evaluation evaluation : cours.getListeEvaluation()){
                Calculs.calculEcartType(evaluation);
                Calculs.calculMediane(evaluation);
                Calculs.calculMode(evaluation);
                Calculs.calculMoyenne(evaluation);
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
    
}
