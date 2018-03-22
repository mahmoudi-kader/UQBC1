package inf2015.tp1.uqbc;

import inf2015.tp1.uqbc.fichiers.CreerDocument;
import inf2015.tp1.uqbc.fichiers.FichierJSON;
import inf2015.tp1.uqbc.fichiers.TraitementFichiers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benoit
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        //String repertoire = "/home/benoit/NetBeansProjects/UQBC1/project_TP-INF-2015/fichiers/";
        
        //List<FichierJSON> listeFichiers = new ArrayList();
        //TraitementFichiers.ramasser(repertoire, listeFichiers);
        //List<Cours> listeCours = TraitementFichiers.chargerDonnees(listeFichiers);
        //traiter chargement objets : Benoit
        
        
        //TODO Nawal Calculs
        
        
        
        //TODO Amine & Abdel
        
        List<Evaluation> listeEvaluation = new ArrayList<Evaluation>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        
        Cours cours1 = new Cours("BIO", "Gr10", "H18", "BlaBla", "1012");
        Etudiant etudiantTemp1 = new Etudiant("SADN27272727","Saddd","Naaaa");
        Etudiant etudiantTemp2 = new Etudiant("DASS27272727","Dasss","Naaaa");
        listeEtudiant.add(etudiantTemp1);
        listeEtudiant.add(etudiantTemp2);
        cours1.setListeEtudiant(listeEtudiant);
        
        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2,15.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1,13.0));
        listeEvaluation.add(new Evaluation("blabla", "1", "TP", "TP", "20%"));
        listeEvaluation.get(0).setListeResultatEvaluation(listeResultatEvaluation);
        
        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2,35.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1,38.0));
        listeEvaluation.add(new Evaluation("blabla", "2", "Examen intra", "Examen", "40%"));
        listeEvaluation.get(1).setListeResultatEvaluation(listeResultatEvaluation);
        
        listeResultatEvaluation = new ArrayList<ResultatEvaluation>();
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp2,36.0));
        listeResultatEvaluation.add(new ResultatEvaluation(etudiantTemp1,36.0));
        listeEvaluation.add(new Evaluation("blabla", "3", "Examen final", "Examen", "40%"));
        listeEvaluation.get(2).setListeResultatEvaluation(listeResultatEvaluation);
        cours1.setListeEvaluation(listeEvaluation);
        
        List<Cours> listeCours = new ArrayList<Cours>();
        listeCours.add(cours1);
        double moyenneCours = cours1.getMoyenneGroupe();
        String noteEvaluation = cours1.noteEtudiantGlobal(cours1.getListeEtudiant(), cours1.getListeEvaluation()).get(0);
        System.out.println("La moyenne du cours " + moyenneCours);
        System.out.println(noteEvaluation);
        
        CreerDocument creerDocument = new CreerDocument();
        creerDocument.EcrireFichier(listeCours);
        
    }
    
}
