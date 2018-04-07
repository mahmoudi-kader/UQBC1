package inf2015.tp1.uqbc;

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
    
    
}
