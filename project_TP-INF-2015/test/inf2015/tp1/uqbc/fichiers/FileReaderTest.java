/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author DALIL
 */
public class FileReaderTest {
    
    public FileReaderTest() {
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
    public void testStringFromFile() {
        
        String repertoire = "./";
        String content = "";
        String expecte = "{\"commentaire\":\"Liste etudiants cours BIO1012 Biologie animale - UQBC - Session H2018 - Groupe 10\",\n" +
"\"donnees\":[{\"code_permanent\":\"MAR080996\",\"nom\":\"Martel\",\"prenom\":\"Ãˆve\"},\n" +
"{\"code_permanent\":\"BEA310797\",\"nom\":\"Beauregard\",\"prenom\":\"Emma\"},\n" +
"{\"code_permanent\":\"DUT060897\",\"nom\":\"Dutil\",\"prenom\":\"emile\"},\n" +
"{\"code_permanent\":\"BER300498\",\"nom\":\"Bernier\",\"prenom\":\"Renaud\"},\n" +
"{\"code_permanent\":\"VEI130499\",\"nom\":\"Veilleux\",\"prenom\":\"Gabrielle\"},\n" +
"{\"code_permanent\":\"ROS180597\",\"nom\":\"Ross\",\"prenom\":\"GeneviÃ¨]ve\"}]}";
        
        File fichier = new File("C:\\Users\\DALIL\\Desktop\\UQBC1\\project_TP-INF-2015\\fichiers\\ListeEtudiantsCoursBIO1012-Gr10-H18.json");
        
        
        Assert.assertTrue(fichier.canRead());
        //System.out.print(repertoire);
        
        Assert.assertTrue(fichier.exists());
        
        content = FileReader.StringFromFile("C:\\Users\\DALIL\\Desktop\\UQBC1\\project_TP-INF-2015\\fichiers\\ListeEtudiantsCoursBIO1012-Gr10-H18.json");
   
        System.out.print(content);
        
        Assert.assertEquals("Faux", expecte , content);

    }
    
}
