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
import org.junit.Test;

/**
 *
 * @author nawal
 */
public class CalculsTest {
    
    public CalculsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void testCalculs(){
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant= new ArrayList<Etudiant>();
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp = new Etudiant("SADN27272727","Saddd","Naaaa");
        listeEtudiant.add(etudiantTemp);
        etudiantTemp = new Etudiant("DASS27272727","Dasss","Naaaa");
        listeEtudiant.add(etudiantTemp);
        
        double moyenne = cours1.getMoyenneGroupe();
        
        Assert.assertEquals("La moyenne du cours " + cours1.getTitre() + " est ", 21.33, moyenne);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
