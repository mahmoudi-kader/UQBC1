package inf2015.tp1.uqbc;

import inf2015.tp1.uqbc.fichiers.CreerDocument;
import inf2015.tp1.uqbc.fichiers.FichierJSON;
import inf2015.tp1.uqbc.fichiers.TraitementFichiers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale qui exécute le programme.
 * @author benoit
 */
public class Application {

    /**
     * @param args Les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        
        String repertoire = null;
        if(args[0] != null && new File(args[0]).canRead() ){
            repertoire = args[0];
        }

        //String repertoire = "/home/benoit/NetBeansProjects/UQBC1/project_TP-INF-2015/fichiers/";

        List<FichierJSON> listeFichiers = new ArrayList();
        TraitementFichiers.ramasser(repertoire, listeFichiers);
        List<Cours> listeCours = TraitementFichiers.chargerDonnees(listeFichiers);

        //TODO Amine & Abdel
        

    }
    
}
