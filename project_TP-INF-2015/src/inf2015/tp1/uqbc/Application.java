package inf2015.tp1.uqbc;

import inf2015.tp1.uqbc.fichiers.FichierJSON;
import inf2015.tp1.uqbc.fichiers.TraitementFichiers;
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
    public static void main(String[] args) {
        
        
        String repertoire = "/home/benoit/NetBeansProjects/UQBC1/project_TP-INF-2015/fichiers/";
        
        List<FichierJSON> listeFichiers = new ArrayList();
        TraitementFichiers.ramasser(repertoire, listeFichiers);
        List<Cours> listeCours = TraitementFichiers.chargerDonnees(listeFichiers);
        //traiter chargement objets : Benoit
        
        
        //TODO Nawal Calculs
        
        
        
        //TODO Amine & Abdel
        
        
        
    }
    
}
