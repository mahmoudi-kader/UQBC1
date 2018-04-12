/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ResultatEvaluation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author benoit
 */
public class CreerResultatsGroupeCoursTest {
    
    private String finLigne = System.lineSeparator();
    private long version = new Date(118,01,01).getTime();
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
       
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEcrireFichier(){
        
        List<Cours> listeCours = new ArrayList<>();
        Cours cours = new Cours();
        cours.setCommentaire("Commentaire cours");
        cours.setGroupe("groupe 1");
        cours.setNumeroCours("TEST101");
        cours.setSession("Hiver-2018");
        cours.setTitre("Agilité 101");
        
        Etudiant etudiant = new Etudiant();
        etudiant.setCodePermanent("TST1235346");
        etudiant.setNom("NomTEST");
        etudiant.setPrenom("PrenomTest");
        
        cours.getListeEtudiant().add(etudiant);
        
        Evaluation evaluation = new Evaluation();      
        evaluation.setCommentaire("commentaire");
        evaluation.setNomEvaluation("nom evaluation 1");
        evaluation.setNumeroEvaluation("1");
        evaluation.setPonderation("20 %");
        evaluation.setType("examen");
        cours.getListeEvaluation().add(evaluation);
        
        ResultatEvaluation re = new ResultatEvaluation();
        re.setEtudiant(etudiant);
        re.setNote(20.0);
        evaluation.getListeResultatEvaluation().add(re);
        
        
        cours.getListeEvaluation().add(evaluation);
        
        evaluation = new Evaluation();
        evaluation.setCommentaire("commentaire2");
        evaluation.setNomEvaluation("nom evaluation 2");
        evaluation.setNumeroEvaluation("2");
        evaluation.setPonderation("80 %");
        evaluation.setType("examen");
        
        re = new ResultatEvaluation();
        re.setEtudiant(etudiant);
        re.setNote(80.0);
        evaluation.getListeResultatEvaluation().add(re);
        cours.getListeEvaluation().add(evaluation);
        
        listeCours.add(cours);
        
        String nomFichier = "./Agilité 101/groupe 1-Agilité 101.txt";
        
        File monFichier = new File(nomFichier);
        
        if(monFichier.exists()){
            monFichier.delete();
        }
        Assert.assertFalse(monFichier.exists());
        
        CreerResultatsGroupeCours creerResultatsGroupeCours = new CreerResultatsGroupeCours(version);
        creerResultatsGroupeCours.ecrireFichier(listeCours);
          
        Assert.assertTrue(monFichier.exists());
        monFichier.delete();
    }
    
    
}
