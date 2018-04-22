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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abdelkader
 */
public class CreerJsonRegistraireTest {
    
    private long version = new Date(118,01,01).getTime(); 
    private String sepFichier = System.getProperty("file.separator");
    
    public CreerJsonRegistraireTest() {
    }
    
    @Test
    public void testCreerJson() throws Exception {


        String repertoireDestination = "./";
        String cours_groupe="";
        String fileContent="";


        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        List<Cours> cours = new ArrayList<Cours>();
        String expected="[{\"Groupe: \":\"Gr11\"},{\"sigle: \":\"BIO1012\"},{\"Version:\":\"2018.02.01 AD at 00:00:00 EST \"},{\"Notes des etudiants: \":[{\"Code_permanent: \":\"ABC27272727\",\"Note: \":45},{\"Code_permanent: \":\"XYZ27272727\",\"Note: \":86}]}]";

        Cours cours1 = new Cours("BIO1012", "Gr11", "H18", "BlaBla", "1012");
        cours.add(cours1);
        cours_groupe=cours1.getTitre()+cours1.getGroupe();
        
        Etudiant etudiantTemp1 = new Etudiant("ABC27272727", "AABB", "Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("XYZ27272727", "XXYY", "Naaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        cours1.setListeEtudiant(listeEtudiant);

        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 15.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 10.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 35.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 15.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);

        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2, 36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1, 20.0));
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
        
        CreerJsonRegistraire creation= new CreerJsonRegistraire();
        creation.CreerJson(cours);
        fileContent=FileReader.StringFromFile(repertoireDestination+sepFichier+cours1.getTitre()+sepFichier+cours_groupe+".json");
        assertTrue(fileContent != null && fileContent.length()>0);
    }
    
}
