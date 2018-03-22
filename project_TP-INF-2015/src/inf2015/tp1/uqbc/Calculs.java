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
                total = 0;
                nombreEvaluation = 0;
                if(validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true){
                    for(ResultatEvaluation resultat:evaluation.getListeResultatEvaluation()){
                        if(resultat.getNote() >= 0){
                            total = total + resultat.getNote();
                            nombreEvaluation++;
                        }
                    }
                } else {
                    total = 0;
                    nombreEvaluation = 1;
                }
                moyenne = moyenne + (total / nombreEvaluation);
            }
        }
        return arrondirChiffre(moyenne,1);
    }
    
    public static double calculPonderationGroupeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation){
        boolean ponderationExiste = false;
        double total = 0;
        for(Evaluation evaluation : listeEvaluation){
            if(validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true){
                for(ResultatEvaluation resultat:evaluation.getListeResultatEvaluation()){
                    if(resultat.getNote() >= 0){
                        ponderationExiste = true;
                    }
                } 
            }
            if(ponderationExiste = true) total = total + convertirPonderation(evaluation.getPonderation());
         }
        return arrondirChiffre(total,1);
    }
    
    public static double calculMoyenneGroupeEvaluation(List<ResultatEvaluation> listeResultatEvaluation){
        double moyenne = 0;
        double total = 0;
        int nombreEvaluation = 0;
            for(ResultatEvaluation resultat:listeResultatEvaluation){
                if(resultat.getNote() >= 0){
                    total = total + resultat.getNote();
                    nombreEvaluation++;
                }
            }
            moyenne = moyenne + (total / nombreEvaluation);
        return arrondirChiffre(moyenne,1);
    }
    
    public static double calculNotePondereeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent){
        double notePonderee=0;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            total = 0;
            nombreEvaluation = 0;
            if(validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true){
                for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                    if(resultat.getEtudiant().getCodePermanent().equalsIgnoreCase(codeParmanent) && resultat.getNote() >= 0){
                        total = total + resultat.getNote();
                        nombreEvaluation++;
                    }
                } 
            } else {
                total = 0;
                nombreEvaluation = 1;
            }
        }
        notePonderee = notePonderee + (total / nombreEvaluation);
        return arrondirChiffre(notePonderee,1);
    }
    
    public static double calculPonderationGlobaleEtudiant(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent){
        double notePonderee=0;
        boolean ponderationExiste = false;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            total = 0;
            nombreEvaluation = 0;
            if(validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true){
                for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                    if(resultat.getEtudiant().getCodePermanent().equalsIgnoreCase(codeParmanent) && resultat.getNote() >= 0){
                        ponderationExiste = true;
                    }
                } 
            } else {
                total = 0;
                nombreEvaluation = 1;
            }
            if(ponderationExiste = true) total = total + convertirPonderation(evaluation.getPonderation());
        }
        return arrondirChiffre(total,1);
    }
    
    public static double calculNotePondereeEvaluation(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent, String numeroEvaluation){
        double notePonderee=0;
        double total = 0;
        int nombreEvaluation = 0;
        for(Evaluation evaluation : listeEvaluation){
            total = 0;
            nombreEvaluation = 0;
            if(validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true){
                for(ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()){
                    if(resultat.getEtudiant().getCodePermanent().equalsIgnoreCase(codeParmanent) && resultat.getNote() >= 0){
                        total = total + resultat.getNote();
                        nombreEvaluation++;
                    }
                } 
            } else {
                total = 0;
                nombreEvaluation = 1;
            }
        }
        notePonderee = notePonderee + (total / nombreEvaluation);
        return arrondirChiffre(notePonderee,1);
    }
    
    private static double convertirPonderation(String ponderation){
        double nombre = 0;
        
        nombre = Double.parseDouble(ponderation.substring(0, ponderation.length() - 1));
        
        return nombre;
    }
    
    public static boolean validerEtudiantEvaluation(List<Etudiant> listeEtudiant, List<ResultatEvaluation> listeResultatEvaluation){
        boolean evaluationValide = false;
        String codePermanentEtudiant = null;
        boolean valide = false;
        int i=0;
        for(int j = 0; j < listeResultatEvaluation.size() ; j++){
            codePermanentEtudiant = listeResultatEvaluation.get(j).getEtudiant().getCodePermanent();
            i = 0;
            valide = false;
            while(i < listeEtudiant.size() && valide == false){
                if(!codePermanentEtudiant.equals(listeEtudiant.get(i).getCodePermanent())){
                    valide = true;
                }
                i++;
            }
            if (valide == true){
                evaluationValide = true;
            }else{
                evaluationValide = false;
            }
        }
        return evaluationValide;
    }
    public static double arrondirChiffre(double val, int pos){
        if(((""+val).substring((""+val).indexOf('.')+1)).length()>pos+1){
                int lastNumber = Integer.parseInt(""+(""+val).substring((""+val).indexOf('.')+pos+1, (""+val).indexOf('.')+pos+2));
                double response = (double)((int) (val*Math.pow(10, pos+1)));

        response = response / Math.pow(10, pos+1);

        if(lastNumber >=5){
                if(response>0){
                        response = response + 0.0001;
                }else{
                        response = response - 0.0001;
                }

                response = (double)((int) (response*Math.pow(10, pos)));
                response = response / Math.pow(10, pos);
        }else{
                response = (double)((int) (response*Math.pow(10, pos)));
                response = response / Math.pow(10, pos);
        }

        return response;
        }else{

                return val;
        }
    }
}
