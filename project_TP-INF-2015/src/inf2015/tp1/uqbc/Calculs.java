package inf2015.tp1.uqbc;

import java.util.List;

/**
 *
 * Classe pour calculer les moyennes et ponderations
 */
public class Calculs {
    
    public static double calculMoyenneGroupeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation){
        double moyenne = 0;
        double total = 0;
        int nombreEvaluation = 0;
        if (!(listeEvaluation == null)){
            for(Evaluation evaluation : listeEvaluation){
                for(ResultatEvaluation resultat:evaluation.getListeResultatEvaluation()){
                    if(validerEtudiantEvaluation(listeEtudiant, resultat) == true){
                        if(resultat.getNote() > 0){
                            total = total + resultat.getNote();
                            nombreEvaluation++;
                        }
                    }
                }
                moyenne = moyenne + (total / nombreEvaluation);
            }
        }
        return moyenne;
    }
    
    public static double calculPonderationGroupeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation){
        boolean ponderationExiste = false;
        double total = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat:evaluation.getListeResultatEvaluation()){
                if(validerEtudiantEvaluation(listeEtudiant, resultat) == true){
                    if(resultat.getNote() > 0){
                        ponderationExiste = true;
                    }
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
                //if(validerEtudiantEvaluation(listeEtudiant, resultat) == true){
                    if(resultat.getNote() > 0){
                        total = total + resultat.getNote();
                        nombreEvaluation++;
                    }
                //}
            }
            System.out.println("total" + total);
            System.out.println("nombreEvaluation" + nombreEvaluation);
            moyenne = moyenne + (total / nombreEvaluation);
        return moyenne;
    }
    
    public static double calculNotePondereeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent){
        double notePonderee=0;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                if(validerEtudiantEvaluation(listeEtudiant, resultat) == true){
                    if(resultat.getEtudiant().equals(codeParmanent) && resultat.getNote() > 0){
                        total = total + resultat.getNote();
                        nombreEvaluation++;
                    }
                }
            }
        }
        notePonderee = notePonderee + (total / nombreEvaluation);
        return notePonderee;
    }
    
    public static double calculPonderationGlobaleEtudiant(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent){
        double notePonderee=0;
        boolean ponderationExiste = false;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                if(validerEtudiantEvaluation(listeEtudiant, resultat) == true){
                        if(resultat.getEtudiant().equals(codeParmanent) && resultat.getNote() > 0){
                        ponderationExiste = true;
                    }
                }
            }
            if(ponderationExiste = true) total = total + convertirPonderation(evaluation.getPonderation());
        }
        return total;
    }
    
    public static double calculNotePondereeEvaluation(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent, String numeroEvaluation){
        double notePonderee=0;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                if(validerEtudiantEvaluation(listeEtudiant, resultat) == true){
                    if(resultat.getEtudiant().equals(codeParmanent) && resultat.getNote() > 0){
                        total = total + resultat.getNote();
                        nombreEvaluation++;
                    }
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
    
    public static boolean validerEtudiantEvaluation(List<Etudiant> listeEtudiant, ResultatEvaluation resultatEvaluation){
        boolean evaluationValide = true;
        String codePermanentEtudiant = null;
        int i=0;
        codePermanentEtudiant = resultatEvaluation.getEtudiant().getCodePermanent();
        i = 0;
        while(i < listeEtudiant.size() && evaluationValide == true){
            if(!codePermanentEtudiant.equals(listeEtudiant.get(i).getCodePermanent())){
                evaluationValide = false;
            }
            i++;
        }
        return evaluationValide;
    }
}
