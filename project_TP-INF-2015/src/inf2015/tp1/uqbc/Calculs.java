package inf2015.tp1.uqbc;

import java.util.List;

/**
 *
 * Classe pour calculer les moyennes et ponderations
 */
public class Calculs {
    
    public static double calculMoyenneGroupeGlobale(List<Evaluation> listeEvaluation){
        double moyenne = 0;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat:evaluation.getListeResultatEvaluation()){
                if(resultat.getNote() > 0){
                    total = total + resultat.getNote();
                    nombreEvaluation++;
                }
            }
            moyenne = moyenne + (total / nombreEvaluation);
        }
        return moyenne;
    }
    
    public static double calculPonderationGroupeGlobale(List<Evaluation> listeEvaluation){
        boolean ponderationExiste = false;
        double total = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat:evaluation.getListeResultatEvaluation()){
                if(resultat.getNote() > 0){
                    ponderationExiste = true;
                }
            }
            if(ponderationExiste = true) total = total + convertirPonderation(evaluation.getPonderation());
         }
        return total;
    }
    
    public static double calculMoyenneGroupeEvaluation(List<ResultatEvaluation> listeResultatEvaluation){
        double moyenne = 0;
        double total = 0;
        int nombreEvaluation = 0;
            for(ResultatEvaluation resultat:listeResultatEvaluation){
                if(resultat.getNote() > 0){
                    total = total + resultat.getNote();
                    nombreEvaluation++;
                }
            }
            moyenne = moyenne + (total / nombreEvaluation);
        return moyenne;
    }
    
    public static double calculNotePondereeGlobale(List<Evaluation> listeEvaluation, String codeParmanent){
        double notePonderee=0;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                if(resultat.getEtudiant().equals(codeParmanent) && resultat.getNote() > 0){
                    total = total + resultat.getNote();
                    nombreEvaluation++;
                }
            }
        }
        notePonderee = notePonderee + (total / nombreEvaluation);
        return notePonderee;
    }
    
    public static double calculPonderationGlobaleEtudiant(List<Evaluation> listeEvaluation, String codeParmanent){
        double notePonderee=0;
        boolean ponderationExiste = false;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                if(resultat.getEtudiant().equals(codeParmanent) && resultat.getNote() > 0){
                    ponderationExiste = true;
                }
            }
            if(ponderationExiste = true) total = total + convertirPonderation(evaluation.getPonderation());
        }
        return total;
    }
    
    public static double calculNotePondereeEvaluation(List<Evaluation> listeEvaluation, String codeParmanent, String numeroEvaluation){
        double notePonderee=0;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                if(resultat.getEtudiant().equals(codeParmanent) && resultat.getNote() > 0){
                    total = total + resultat.getNote();
                    nombreEvaluation++;
                }
            }
        }
        notePonderee = notePonderee + (total / nombreEvaluation);
        return notePonderee;
    }
    
    private static double convertirPonderation(String ponderation){
        double nombre = 0;
        
        nombre = Double.parseDouble(ponderation.substring(0, ponderation.length() - 1));
        
        return nombre;
    }
            
            
}
