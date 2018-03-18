/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author nawal
 */
public class CalculsTest {
    
    public CalculsTest() {
    }
    
    @Test
    public void testCalculs(){
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SADN27272727","Saddd","Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DASS27272727","Dasss","Naaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        cours1.setListeEtudiant(listeEtudiant);
        
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2,15.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1,13.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);
        
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2,35.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1,38.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);
        
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2,36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1,36.0));
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
        
        double moyenneCours = cours1.getMoyenneGroupe();
        double moyenneEvaluation = 0;
        System.out.println("La moyenne du cours " + moyenneCours);
        Assert.assertEquals(86.5, moyenneCours,0.001);
        System.out.println(cours1.getListeEvaluation().get(0).getListeResultatEvaluation().get(0).getNote());
        System.out.println(cours1.getListeEvaluation().get(0).getListeResultatEvaluation().get(1).getNote());
        moyenneEvaluation = cours1.getListeEvaluation().get(0).getMoyenneGroupeEvaluation();
        Assert.assertEquals(14.0, moyenneEvaluation,0.001);
    }
}
