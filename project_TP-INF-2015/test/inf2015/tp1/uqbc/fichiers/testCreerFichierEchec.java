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
import inf2015.tp1.uqbc.validation.ValidationReussite;
import java.util.ArrayList;
import java.util.Date;
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
 * @author nawal
 */
public class testCreerFichierEchec {
    
    private long version = new Date(118,01,01).getTime();
    
    public testCreerFichierEchec() {
    }
    
    @Test
    public void testExtraireEtudiantEchec(){
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        List<ValidationReussite> listeEtudiantEchec = new ArrayList<ValidationReussite>();
        
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
        
        CreerFichierEchec test = new CreerFichierEchec(version);
        listeEtudiantEchec = test.extraireEtudiantEchec(cours1);
        for(int i = 0 ; i < listeEtudiantEchec.size() ; i++){
            System.out.print("Code : " + listeEtudiantEchec.get(i).getEtudiant().getCodePermanent());
            System.out.print(" - Nom : " + listeEtudiantEchec.get(i).getEtudiant().getNom());
            System.out.print(" - Prénom : " + listeEtudiantEchec.get(i).getEtudiant().getPrenom());
            System.out.print(" - Note : " + listeEtudiantEchec.get(i).getNote());
            System.out.print(" - Ponderation : " + listeEtudiantEchec.get(i).getPonderation());
            System.out.println(" - Pourcentage réussite : " + listeEtudiantEchec.get(i).getPourcentageReussite());
        }
    }

}
