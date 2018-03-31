/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abdelkader
 */
public class CreerDocumentTest {
    
    public CreerDocumentTest() {
    }
    
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
    public void testEcrireFichier() throws Exception {
        String repertoire = null;
        String repertoireDestination=null;
        repertoire = "C:/Users/Abdelkader/Desktop/UQBC/UQBC1/project_TP-INF-2015/fichiers/";
        repertoireDestination = "C:/Users/Abdelkader/Desktop/UQBC/UQBC1/project_TP-INF-2015/";
        
        List<FichierJSON> listeFichiers = new ArrayList();
        TraitementFichiers.ramasser(repertoire, listeFichiers);
        List<Cours> listeCours = TraitementFichiers.chargerDonnees(listeFichiers);
        CreerDocument creerDocument = new CreerDocument();
        creerDocument.EcrireFichier(listeCours);
       // System.out.println(" TEST methode EcrireFichier");
        Iterator<Cours> it = listeCours.iterator();
 
        while (it.hasNext()) {
        Boolean result = false;
        Cours cours = it.next();
        String nomCours=cours.getTitre();
        File dossier = new File(repertoireDestination+nomCours);
        Boolean repertoireExiste=dossier.exists();
        assertTrue(repertoireExiste);
        // test si fichiers sont crées dans chacun des repertoires
       
    
            for (Etudiant etudiant : cours.getListeEtudiant()) {
                    String   nomFichier = cours.getSession() + "_" + cours.getTitre() + "_" + etudiant.getCodePermanent();
                    File fichierEudiant = new File(dossier.getAbsolutePath()+"\\"+nomFichier+".txt");
                    Boolean fichierEudiantExiste=fichierEudiant.exists();
                    assertTrue(fichierEudiantExiste);
            }
        //

       
    }
    
    }
}
