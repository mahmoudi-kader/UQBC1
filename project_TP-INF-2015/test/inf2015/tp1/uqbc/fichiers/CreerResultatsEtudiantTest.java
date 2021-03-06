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
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
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
public class CreerResultatsEtudiantTest {
    
    private static final String finLigne = System.lineSeparator();
    private static final String sepFichier = System.getProperty("file.separator");
    private static final String repertoireParDefaut = "."+sepFichier;
    private long version = new Date(118,01,01).getTime();
    
    public CreerResultatsEtudiantTest() {
    }

    @Test
    public void testEcrireFichier() throws Exception {
      
        String repertoire = null;
        String repertoireDestination=null;
        repertoire = "./";
        repertoireDestination = "./";
        
        List<FichierJSON> listeFichiers = new ArrayList();
        TraitementFichiers.ramasser(repertoire, listeFichiers);
        List<Cours> listeCours = TraitementFichiers.chargerDonnees(listeFichiers);
        CreerResultatsEtudiant creerDocument = new CreerResultatsEtudiant(version);
        creerDocument.ecrireFichier(listeCours);
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
                    File fichierEudiant = new File(dossier.getAbsolutePath()+sepFichier+nomFichier+".txt");
                    Boolean fichierEudiantExiste=fichierEudiant.exists();
                    assertTrue(fichierEudiantExiste);
            }
       
    }
        
    }
    
    @Test   
    public void testerGetVersion(){
        String versionAttendue = "Version : 2018.02.01 AD at 00:00:00 EST ";//"Version : "+ new SimpleDateFormat().format(new Date(this.version)) +"\n";
        
        CreerResultatsEtudiant creerDocument = new CreerResultatsEtudiant(version);
        
        String resultat = creerDocument.getVersion();
        
        
        Assert.assertEquals("", versionAttendue, "Version : 2018.02.01 AD at 00:00:00 EST ");
    }    

    @Test   
     public void testerContenu() throws IOException{
        String repertoireDestination = "C:/Users/nawal/Documents/NetBeansProjects/UQBC1/project_TP-INF-2015/";

         // test unitaire ecriture dans le fichier texte
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        List<Cours> mesCours = new ArrayList<Cours>();

        Cours coursAttendu = new Cours();
        coursAttendu.setGroupe("Gr10");
        coursAttendu.setNumeroCours("1012");
        coursAttendu.setSession("H18");
        coursAttendu.setTitre("BIO1012");
        
        Etudiant etudiantTemp1 = new Etudiant("AAA310797", "Saddd", "Naaaa");
        listeEtudiant.add(etudiantTemp1);
        coursAttendu.setListeEtudiant(listeEtudiant);

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 18.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);
        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 23.0));
        listeEvaluation.add(new Evaluation("bla", "2", "Examen intra", "Examen", "40%"));

        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);
        coursAttendu.setListeEvaluation(listeEvaluation);
        mesCours.add(coursAttendu);

        CreerResultatsEtudiant test = new CreerResultatsEtudiant(version);
        test.ecrireFichier(mesCours);
        String path=repertoireDestination+ "\\"+"BIO1012"+"\\"+"H18_BIO1012_AAA310797.txt";

    }
}
