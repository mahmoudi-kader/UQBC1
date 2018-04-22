package inf2015.tp1.uqbc.validation;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ResultatEvaluation;
import java.util.List;

/**
 *
 * @author nawal
 */
public class ValidationEvaluations {
    public static boolean validerEvaluationComplete(Cours cours, Etudiant etudiant){
        boolean validationEvaluation = false;
        boolean validationEtudiant = true;
        for (Evaluation evaluation : cours.getListeEvaluation()){
            validationEvaluation = false;
            for(ResultatEvaluation resultatEvaluation : evaluation.getListeResultatEvaluation()){
                if(resultatEvaluation.getEtudiant().getCodePermanent().equals(etudiant.getCodePermanent())){
                    validationEvaluation = true;
                }
            }
            if(validationEvaluation == true && validationEtudiant == true){
                validationEtudiant = true;
            }else if(validationEvaluation == false){
                validationEtudiant = false;
            }
        }
        return validationEtudiant;
    }
    public static boolean validerPonderationComplete(Cours cours){
        boolean validationPonderation = false;
        double totalPonderation = 0;
        for (Evaluation evaluation : cours.getListeEvaluation()){
            totalPonderation = totalPonderation + Calculs.convertirPonderation(evaluation.getPonderation());
        }
        if (totalPonderation==100){
            validationPonderation = true;
        }
        return validationPonderation;
    }
    
}
