package inf2015.tp1.uqbc;

import java.util.List;

/**
 *
 * Classe pour calculer les moyennes et ponderations
 */
public class Calculs {

    //méthode de calcul de la moyenne du groupe pour un cours
    public static double calculMoyenneGroupeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation) {
        double moyenne = 0;
        double total;
        int nombreEvaluation;
        if (listeEvaluation != null) {
            for (Evaluation evaluation : listeEvaluation) {
                total = 0;
                nombreEvaluation = 0;
                if (validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true) {
                    for (ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()) {
                        if (resultat.getNote() >= 0) {
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
        return arrondirChiffre(moyenne, 1);
    }

    //méthode de calcul de la pondération du groupe pour un cours
    public static double calculPonderationGroupeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation) {
        boolean ponderationExiste = false;
        double total = 0;
        for (Evaluation evaluation : listeEvaluation) {
            if (validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true) {
                for (ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()) {
                    if (resultat.getNote() >= 0) {
                        ponderationExiste = true;
                    }
                }
            }
            if (ponderationExiste) {
                total = total + convertirPonderation(evaluation.getPonderation());
            }
        }
        return arrondirChiffre(total, 1);
    }

    //méthode de calcul de la moyenne du groupe pour une évaluation
    public static double calculMoyenneGroupeEvaluation(List<ResultatEvaluation> listeResultatEvaluation) {
        double moyenne = 0;
        double total = 0;
        int nombreEvaluation = 0;
        for (ResultatEvaluation resultat : listeResultatEvaluation) {
            if (resultat.getNote() >= 0) {
                total = total + resultat.getNote();
                nombreEvaluation++;
            }
        }
        moyenne = moyenne + (total / nombreEvaluation);
        return arrondirChiffre(moyenne, 1);
    }

    //méthode de calcul de la note total pour un cours
    public static double calculNotePondereeGlobale(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent) {
        double notePonderee = 0;
        double total = 0;
        int nombreEvaluation = 0;
        for (Evaluation evaluation : listeEvaluation) {
            if (validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true) {
                for (ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()) {
                    if (resultat.getEtudiant().getCodePermanent().equalsIgnoreCase(codeParmanent) && resultat.getNote() >= 0) {
                        total = total + resultat.getNote();
                        nombreEvaluation++;
                    }
                }
            } else {
                total = 0;
                nombreEvaluation = 1;
            }
        }
        notePonderee = notePonderee + total;
        return arrondirChiffre(notePonderee, 1);
    }

    //méthode de calcul de la pondération par étudiant pour un cours
    public static double calculPonderationGlobaleEtudiant(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent) {
        boolean ponderationExiste = false;
        double total = 0;
        for (Evaluation evaluation : listeEvaluation) {
            //total = 0;
            ponderationExiste = false;
            if (validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true) {
                for (ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()) {
                    if (resultat.getEtudiant().getCodePermanent().equalsIgnoreCase(codeParmanent) && resultat.getNote() >= 0) {
                        ponderationExiste = true;
                    }
                }
            } else {
                total = 0;
            }
            if (ponderationExiste) {
                total = total + convertirPonderation(evaluation.getPonderation());
            }
        }
        return arrondirChiffre(total, 1);
    }

    //méthode de calcul de la note pondérée par évaluation
    public static double calculNotePondereeEvaluation(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation, String codeParmanent, String numeroEvaluation) {
        double notePonderee = 0;
        double total = 0;
        int nombreEvaluation = 0;
        for (Evaluation evaluation : listeEvaluation) {
            //total = 0;
            //nombreEvaluation = 0;
            if (validerEtudiantEvaluation(listeEtudiant, evaluation.getListeResultatEvaluation()) == true) {
                if(evaluation.getNumeroEvaluation().equalsIgnoreCase(numeroEvaluation)){
                    for (ResultatEvaluation resultat : evaluation.getListeResultatEvaluation()) {
                        if (resultat.getEtudiant().getCodePermanent().equalsIgnoreCase(codeParmanent) && resultat.getNote() >= 0) {
                            total = total + resultat.getNote();
                            nombreEvaluation++;
                        }
                    }
                }
            } else {
                total = 0;
                nombreEvaluation = 1;
            }
        }
        notePonderee = notePonderee + (total / nombreEvaluation);
        return arrondirChiffre(notePonderee, 1);
    }

    //méthode qui permet de convertir un texte en double
    public static double convertirPonderation(String ponderation) {
        double nombre = Double.parseDouble(ponderation.substring(0, ponderation.length() - 1));

        return nombre;
    }

    private static boolean validerEtudiantEvaluation(List<Etudiant> listeEtudiant, List<ResultatEvaluation> listeResultatEvaluation) {
        boolean evaluationValide = false;
        String codePermanentEtudiant;
        boolean valide;
        int i;
        for (int j = 0; j < listeResultatEvaluation.size(); j++) {
            codePermanentEtudiant = listeResultatEvaluation.get(j).getEtudiant().getCodePermanent();
            i = 0;
            valide = false;
            while (i < listeEtudiant.size() && valide == false) {
                if (codePermanentEtudiant.equals(listeEtudiant.get(i).getCodePermanent())) {
                    valide = true;
                }
                i++;
            }
            evaluationValide = valide;
        }
        return evaluationValide;
    }

    private static double arrondirChiffre(double val, int pos) {
        if ((("" + val).substring(("" + val).indexOf('.') + 1)).length() > pos + 1) {
            int lastNumber = Integer.parseInt("" + ("" + val).substring(("" + val).indexOf('.') + pos + 1, ("" + val).indexOf('.') + pos + 2));
            double response = (double) ((int) (val * Math.pow(10, pos + 1)));

            response = response / Math.pow(10, pos + 1);

            if (lastNumber >= 5) {
                if (response > 0) {
                    response = response + 0.0001;
                } else {
                    response = response - 0.0001;
                }

                response = (double) ((int) (response * Math.pow(10, pos)));
                response = response / Math.pow(10, pos);
            } else {
                response = (double) ((int) (response * Math.pow(10, pos)));
                response = response / Math.pow(10, pos);
            }

            return response;
        } else {

            return val;
        }
    }
    
    private static double[] trierNotes(Evaluation evaluation){
        double valeurTemp = 0;
        boolean triEffectue = true;
        int i = 0;
        int nbreValeurs = evaluation.getListeResultatEvaluation().size();
        double notes[] = new double[nbreValeurs];
        for(ResultatEvaluation resultatEvaluation : evaluation.getListeResultatEvaluation()){
            notes[i] = resultatEvaluation.getNote();
            ++i;
        }
        while(triEffectue){
            triEffectue = false;
            for(i=0; i < notes.length-1; i++){
                if (notes[i] > notes[i+1]){
                    valeurTemp = notes[i];
                    notes[i] = notes[i+1];
                    notes[i+1] = valeurTemp;
                    triEffectue = true;
                }
            }
        }
        return notes;
    }
    
    public static double calculMoyenne(Evaluation evaluation){
        double moyenne = 0;
        double notes = 0;
        int nbreEtudiants = 0;
        for(ResultatEvaluation resultatEvaluation : evaluation.getListeResultatEvaluation()){
            notes = notes + resultatEvaluation.getNote();
            nbreEtudiants = nbreEtudiants + 1;
        }
        if(nbreEtudiants > 0) moyenne = notes / nbreEtudiants;
        return arrondirChiffre(moyenne,1);
    }
    
    public static double calculMode(Evaluation evaluation){
        double mode = 0;
        double notes[] = new double[30];
        int i = 0;
        int compteCourant = 0;
        int compteMode = 0;
        for(ResultatEvaluation resultatEvaluation : evaluation.getListeResultatEvaluation()){
            notes[i] = resultatEvaluation.getNote();
            ++i;
        }
        for(ResultatEvaluation resultatEvaluation : evaluation.getListeResultatEvaluation()){
            compteCourant = 0;
            for (double element : notes){
                if (resultatEvaluation.getNote() == element){
                        compteCourant++;
                }
            }

            if (compteCourant > compteMode){
                compteMode = compteCourant;
                mode = resultatEvaluation.getNote();
            }
        }
        return arrondirChiffre(mode, 1);
    }
    
    public static double calculMediane(Evaluation evaluation){
        double mediane = 0;
        double listeTrier[] = trierNotes(evaluation);
        
        if (listeTrier.length % 2 == 0){
            int indexA = (listeTrier.length - 1) / 2;
            int indexB = listeTrier.length / 2;

            mediane = (listeTrier[indexA] + listeTrier[indexB]) / 2;
        } else {
            int index = (listeTrier.length - 1) / 2;
            mediane = listeTrier[ index ];
        }
        return arrondirChiffre(mediane,1);
    }
    
    public static double calculEcartType(Evaluation evaluation){
        double ecartType = 0;
        double notes = 0;
        double moyenne = 0;
        int nbreEtudiants = 0;
        moyenne = calculMoyenne(evaluation);
        for(ResultatEvaluation resultatEvaluation : evaluation.getListeResultatEvaluation()){
            notes = notes + ((resultatEvaluation.getNote() - moyenne)*(resultatEvaluation.getNote() - moyenne));
            nbreEtudiants = nbreEtudiants + 1;
        }
        if(nbreEtudiants > 0) ecartType = Math.sqrt(notes / nbreEtudiants);
        return arrondirChiffre(ecartType,1);
    }
    
    public static int calculNbreEtudiants(Evaluation evaluation){
        int nbreEtudiants = 0;
        for(int i = 0; i < evaluation.getListeResultatEvaluation().size(); ++i){
            nbreEtudiants = nbreEtudiants + 1;
        }
        return nbreEtudiants;
    }
    
    public static double calculNoteGlobalEtudiant(Cours cours, Etudiant etudiant){
        double notes = 0;
        
        for(Evaluation evaluation : cours.getListeEvaluation()){
            for(ResultatEvaluation resultatEvaluation : evaluation.getListeResultatEvaluation()){
                if(resultatEvaluation.getEtudiant().getCodePermanent().equalsIgnoreCase(etudiant.getCodePermanent())){
                    notes = notes + resultatEvaluation.getNote();
                }
            }
        }

        return notes;
    }
    
    public static double calculPourcentageReussite(Cours cours, Etudiant etudiant){
        double notes = 0;
        double ponderation = 0;
        double pourcentageReussite = 0;
        
        notes = calculNoteGlobalEtudiant(cours, etudiant);
        
        ponderation = calculPonderationGlobaleEtudiant(cours.getListeEtudiant(), cours.getListeEvaluation(), etudiant.getCodePermanent());
        
        if(ponderation > 0){
            pourcentageReussite = notes * 100/ponderation;
        }
        
        return pourcentageReussite;
    }
}
