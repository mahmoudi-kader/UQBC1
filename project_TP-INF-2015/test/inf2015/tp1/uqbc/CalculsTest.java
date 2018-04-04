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
    public void testCalculs() {
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        double moyenneCours = 0;
        double ponderationCours = 0;
        double moyenneGroupeEvaluation = 0;
        double notePondereeGlobale = 0;
        double ponderationGlobaleEtudiant = 0;
        double notePondereeEvaluation = 0;
        
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
                
        moyenneCours = Calculs.calculMoyenneGroupeGlobale(cours1.getListeEtudiant(), cours1.getListeEvaluation());
        System.out.println("moyenneCours : " + moyenneCours);
        Assert.assertEquals(86.5, moyenneCours, 0.001);
        
        ponderationCours = Calculs.calculPonderationGroupeGlobale(cours1.getListeEtudiant(), cours1.getListeEvaluation());
        System.out.println("ponderationCours : " + ponderationCours);
        Assert.assertEquals(100.0, ponderationCours, 0.001);
        
        moyenneGroupeEvaluation = Calculs.calculMoyenneGroupeEvaluation(cours1.getListeEvaluation().get(0).getListeResultatEvaluation());
        System.out.println("moyenneGroupeEvaluation : " + moyenneGroupeEvaluation);
        Assert.assertEquals(14.0, moyenneGroupeEvaluation, 0.001);
        
        notePondereeEvaluation = Calculs.calculNotePondereeEvaluation(cours1.getListeEtudiant(), cours1.getListeEvaluation(), "SADN27272727", "2");
        System.out.println("notePondereeEvaluation : " + notePondereeEvaluation);
        Assert.assertEquals(38.0, notePondereeEvaluation, 0.001);
        
        notePondereeGlobale = Calculs.calculNotePondereeGlobale(cours1.getListeEtudiant(), cours1.getListeEvaluation(), "SADN27272727");
        System.out.println("notePondereeGlobale : " + notePondereeGlobale);
        Assert.assertEquals(87.0, notePondereeGlobale, 0.001);
        
        ponderationGlobaleEtudiant = Calculs.calculPonderationGlobaleEtudiant(cours1.getListeEtudiant(), cours1.getListeEvaluation(), "SADN27272727");
        System.out.println("ponderationGlobaleEtudiant : " + ponderationGlobaleEtudiant);
        Assert.assertEquals(100.0, ponderationGlobaleEtudiant, 0.001);
    }
    
    @Test
    public void testCalculsSansEvaluation() {
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        double moyenneCours = 0;
        double ponderationCours = 0;
        double moyenneGroupeEvaluation = 0;
        double notePondereeGlobale = 0;
        double ponderationGlobaleEtudiant = 0;
        double notePondereeEvaluation = 0;
        
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
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
                
        moyenneCours = Calculs.calculMoyenneGroupeGlobale(cours1.getListeEtudiant(), cours1.getListeEvaluation());
        System.out.println("moyenneCours : " + moyenneCours);
        Assert.assertEquals(86.5, moyenneCours, 0.001);
        
        ponderationCours = Calculs.calculPonderationGroupeGlobale(cours1.getListeEtudiant(), cours1.getListeEvaluation());
        System.out.println("ponderationCours : " + ponderationCours);
        Assert.assertEquals(100.0, ponderationCours, 0.001);
        
        moyenneGroupeEvaluation = Calculs.calculMoyenneGroupeEvaluation(cours1.getListeEvaluation().get(0).getListeResultatEvaluation());
        System.out.println("moyenneGroupeEvaluation : " + moyenneGroupeEvaluation);
        Assert.assertEquals(14.0, moyenneGroupeEvaluation, 0.001);
        
        notePondereeEvaluation = Calculs.calculNotePondereeEvaluation(cours1.getListeEtudiant(), cours1.getListeEvaluation(), "SADN27272727", "2");
        System.out.println("notePondereeEvaluation : " + notePondereeEvaluation);
        Assert.assertEquals(38.0, notePondereeEvaluation, 0.001);
        
        notePondereeGlobale = Calculs.calculNotePondereeGlobale(cours1.getListeEtudiant(), cours1.getListeEvaluation(), "SADN27272727");
        System.out.println("notePondereeGlobale : " + notePondereeGlobale);
        Assert.assertEquals(51.0, notePondereeGlobale, 0.001);
        
        ponderationGlobaleEtudiant = Calculs.calculPonderationGlobaleEtudiant(cours1.getListeEtudiant(), cours1.getListeEvaluation(), "SADN27272727");
        System.out.println("ponderationGlobaleEtudiant : " + ponderationGlobaleEtudiant);
        Assert.assertEquals(60.0, ponderationGlobaleEtudiant, 0.001);
    }
}
