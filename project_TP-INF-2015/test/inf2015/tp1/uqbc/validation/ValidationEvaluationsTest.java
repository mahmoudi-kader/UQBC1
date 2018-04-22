package inf2015.tp1.uqbc.validation;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ResultatEvaluation;
import inf2015.tp1.uqbc.validation.ValidationEvaluations;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author nawal
 */
public class ValidationEvaluationsTest {
    
    @Test
    public void testerListeComplete(){
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        boolean etudiantValide = false;
        
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SADN27272727", "Saddd", "Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DASS27272727", "Dasss", "Naaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        cours1.setListeEtudiant(listeEtudiant);

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 15.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 13.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 35.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 38.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 36.0));
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
        
        for(Etudiant etudiant: cours1.getListeEtudiant()){
            etudiantValide = ValidationEvaluations.validerEvaluationComplete(cours1, etudiant);
            Assert.assertTrue(etudiantValide);
        }
        Assert.assertTrue(ValidationEvaluations.validerPonderationComplete(cours1));
    }

    @Test
    public void testerListeIncomplete(){
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        boolean etudiantValide = false;
        
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SADN27272727", "Saddd", "Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DASS27272727", "Dasss", "Naaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        cours1.setListeEtudiant(listeEtudiant);

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 15.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 13.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 38.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 36.0));
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
        
        for(Etudiant etudiant: cours1.getListeEtudiant()){
            etudiantValide = ValidationEvaluations.validerEvaluationComplete(cours1, etudiant);
            Assert.assertFalse(etudiantValide);
        }
        Assert.assertTrue(ValidationEvaluations.validerPonderationComplete(cours1));
    }
    @Test
    public void testerPonderationIncomplete(){
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        boolean etudiantValide = false;
        
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SADN27272727", "Saddd", "Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DASS27272727", "Dasss", "Naaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        cours1.setListeEtudiant(listeEtudiant);

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 15.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 13.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 35.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 38.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);

        cours1.setListeEvaluation(listeEvaluation);
        
        for(Etudiant etudiant: cours1.getListeEtudiant()){
            etudiantValide = ValidationEvaluations.validerEvaluationComplete(cours1, etudiant);
            Assert.assertTrue(etudiantValide);
        }
        Assert.assertFalse(ValidationEvaluations.validerPonderationComplete(cours1));
    }
}
