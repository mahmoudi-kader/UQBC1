/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author nawal
 */
public class CalculsTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
   
    private static Cours cours = null;

    @BeforeClass
    public static void setUpClass() {
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        
        cours = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SADN27272727", "Saddd", "Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DASS27272727", "Dasss", "Naaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        cours.setListeEtudiant(listeEtudiant);

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
        cours.setListeEvaluation(listeEvaluation);
    }

    @AfterClass
    public static void tearDownClass() {
        
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
        
    }
    
    @Test
    public void testCalculsMoyenneCours() {

        double moyenneCours = 0;                
        moyenneCours = Calculs.calculMoyenneGroupeGlobale(cours.getListeEtudiant(), cours.getListeEvaluation());
        System.out.println("moyenneCours : " + moyenneCours);
        Assert.assertEquals(86.5, moyenneCours, 0.001);
        
    }
    
    @Test
    public void testCalculsPonderationCours() {     
        double ponderationCours = 0;
        ponderationCours = Calculs.calculPonderationGroupeGlobale(cours.getListeEtudiant(), cours.getListeEvaluation());
        System.out.println("ponderationCours : " + ponderationCours);
        Assert.assertEquals(100.0, ponderationCours, 0.001);
    }
    
    @Test
    public void testCalculsMoyenneGroupeEvaluation() {
        
        double moyenneGroupeEvaluation = 0;
        moyenneGroupeEvaluation = Calculs.calculMoyenneGroupeEvaluation(cours.getListeEvaluation().get(0).getListeResultatEvaluation());
        System.out.println("moyenneGroupeEvaluation : " + moyenneGroupeEvaluation);
        Assert.assertEquals(14.0, moyenneGroupeEvaluation, 0.001);
    }
    
    @Test
    public void testCalculsNotePonderee() {
        
        double notePondereeEvaluation  = 0;
        notePondereeEvaluation = Calculs.calculNotePondereeEvaluation(cours.getListeEtudiant(), cours.getListeEvaluation(), "SADN27272727", "2");
        System.out.println("notePondereeEvaluation : " + notePondereeEvaluation);
        Assert.assertEquals(38.0, notePondereeEvaluation, 0.001);
        
    }
    
    @Test
    public void testCalculsNotePondereeGlobale() {
        
        double notePondereeGlobale = 0;
        notePondereeGlobale = Calculs.calculNotePondereeGlobale(cours.getListeEtudiant(), cours.getListeEvaluation(), "SADN27272727");
        System.out.println("notePondereeGlobale : " + notePondereeGlobale);
        Assert.assertEquals(87.0, notePondereeGlobale, 0.001);

    }
    
    @Test
    public void testCalculsPonderationGlobale() {        
        double ponderationGlobaleEtudiant = 0;
        ponderationGlobaleEtudiant = Calculs.calculPonderationGlobaleEtudiant(cours.getListeEtudiant(), cours.getListeEvaluation(), "SADN27272727");
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
    
    @Test
    public void testCalculsStats() {
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        double mode = 0;
        double moyenne = 0;
        double mediane = 0;
        double ecartType = 0;
        double nombre = 0;
        
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SAD272727", "Saddd", "Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DAS272727", "Dasss", "Naaaa");
        Etudiant etudiantTemp3 = new Etudiant("DAS282828", "Dasss", "Saaaa");
        Etudiant etudiantTemp4 = new Etudiant("DAS292929", "Dasss", "Saaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        listeEtudiant.add(etudiantTemp3);
        listeEtudiant.add(etudiantTemp4);
        cours1.setListeEtudiant(listeEtudiant);

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 15.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 13.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 13.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 14.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 35.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 38.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 38.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 37.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        //listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 39.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 35.0));
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
                
        Evaluation evaluation = cours1.getListeEvaluation().get(0);
        moyenne = Calculs.calculMoyenne(evaluation);
        System.out.println("Moyenne : " + moyenne);
        Assert.assertEquals(13.75, moyenne, 0.001);
        mode = Calculs.calculMode(evaluation);
        System.out.println("Mode : " + mode);
        Assert.assertEquals(13.0, mode, 0.001);
        mediane = Calculs.calculMediane(evaluation);
        System.out.println("Mediane : " + mediane);
        Assert.assertEquals(13.5, mediane, 0.001);
        ecartType = Calculs.calculEcartType(evaluation);
        System.out.println("Ecart-Type : " + ecartType);
        Assert.assertEquals(0.8, ecartType, 0.001);
        nombre = Calculs.calculNbreEtudiants(evaluation);
        System.out.println("Nombre : " + nombre);
        Assert.assertEquals(4, nombre, 0.001);
    }
    @Test
    public void testValiderReussite() {
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        double pourcentageReussite = 0;
        
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SAD272727", "Saddd", "Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DAS272727", "Dasss", "Naaaa");
        Etudiant etudiantTemp3 = new Etudiant("DAS282828", "Dasss", "Saaaa");
        Etudiant etudiantTemp4 = new Etudiant("DAS292929", "Dasss", "Saaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        listeEtudiant.add(etudiantTemp3);
        listeEtudiant.add(etudiantTemp4);
        cours1.setListeEtudiant(listeEtudiant);

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 10.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 13.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp3, 13.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp4, 14.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 20.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 38.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp3, 38.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp4, 37.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        //listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp3, 39.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp4, 35.0));
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
        
        Etudiant etudiant = cours1.getListeEtudiant().get(1);
        pourcentageReussite = Calculs.calculPourcentageReussite(cours1, etudiant);
        System.out.println("pourcentageReussite : " + pourcentageReussite);
        etudiant = cours1.getListeEtudiant().get(0);
        pourcentageReussite = Calculs.calculPourcentageReussite(cours1, etudiant);
        System.out.println("pourcentageReussite : " + pourcentageReussite);
    }
}
