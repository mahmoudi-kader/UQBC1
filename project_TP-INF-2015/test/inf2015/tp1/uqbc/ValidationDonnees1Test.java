package inf2015.tp1.uqbc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author Abdelkader
 */
public class ValidationDonnees1Test extends TestCase {
    
    public ValidationDonnees1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("initialize");
      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String nomRepertoire = "xxx";
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNomRepertoire() {
        System.out.println("getNomRepertoire");
        ValidationDonnees instance = new ValidationDonnees();
        String expResult = "xxx";
        String result = instance.getNomRepertoire();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNomRepertoire() {
        System.out.println("setNomRepertoire");
        String nomRepertoire = "fff";
        ValidationDonnees instance = new ValidationDonnees();
        instance.setNomRepertoire(nomRepertoire);
       String result = instance.getNomRepertoire();
        assertEquals(nomRepertoire, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderRepertoire() {
        System.out.println("validerRepertoire");
        ValidationDonnees instance = new ValidationDonnees();
        instance.validerRepertoire();
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderNomCours() {
        System.out.println("validerNomCours");
        String cours = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerNomCours(cours);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderNumeroCours() {
        System.out.println("validerNumeroCours");
        String cours = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerNumeroCours(cours);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderGroupe() {
        System.out.println("validerGroupe");
        String cours = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerGroupe(cours);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderSession() {
        System.out.println("validerSession");
        String cours = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerSession(cours);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderCodePermanent() {
        System.out.println("validerCodePermanent");
        String cours = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerCodePermanent(cours);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderTypeEvaluation() {
        System.out.println("validerTypeEvaluation");
        String cours = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerTypeEvaluation(cours);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderNomEvaluation() {
        System.out.println("validerNomEvaluation");
        String nomEvaluation = "";
        String typeEvaluation = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerNomEvaluation(nomEvaluation, typeEvaluation);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderNote() {
        System.out.println("validerNote");
        String ponderation = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerNote(ponderation);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValiderPonderation() {
        System.out.println("validerPonderation");
        String ponderation = "";
        ValidationDonnees instance = new ValidationDonnees();
        boolean expResult = false;
        boolean result = instance.validerPonderation(ponderation);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
