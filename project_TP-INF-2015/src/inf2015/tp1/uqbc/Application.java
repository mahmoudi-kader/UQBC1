package inf2015.tp1.uqbc;

import inf2015.tp1.uqbc.fichiers.CreerFichierEchec;
import inf2015.tp1.uqbc.fichiers.CreerJsonRegistraire;
import inf2015.tp1.uqbc.fichiers.CreerResultatsEtudiant;
import inf2015.tp1.uqbc.fichiers.CreerResultatsGroupeCours;
import inf2015.tp1.uqbc.fichiers.FichierJSON;
import inf2015.tp1.uqbc.fichiers.TraitementFichiers;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale qui exécute le programme.
 *
 * @author benoit
 */
public class Application {

    /**
     * @param args Les arguments de la ligne de commande
     */
    
    public static void main(String[] args) throws IOException {

        long version = System.currentTimeMillis();
       /* 
        String repertoire = null;
        if (args!= null && args.length>1 && args[0] != null && new File(args[0]).canRead()) {
            repertoire = args[0];
        }
        */
       String repertoire ="./";
        // String repertoire ="C:/Users/nawal/Documents/NetBeansProjects/UQBC1/project_TP-INF-2015/";
        //String repertoire = "/home/benoit/NetBeansProjects/UQBC1/project_TP-INF-2015/fichiers/";
        List<FichierJSON> listeFichiers = new ArrayList();
        TraitementFichiers.ramasser(repertoire, listeFichiers);
        List<Cours> listeCours = TraitementFichiers.chargerDonnees(listeFichiers);


        CreerResultatsEtudiant creerDocument = new CreerResultatsEtudiant(version);
        creerDocument.ecrireFichier(listeCours);
        
        CreerResultatsGroupeCours resultatGroupeCours = new CreerResultatsGroupeCours(version);
        resultatGroupeCours.ecrireFichier(listeCours);
        
        CreerJsonRegistraire creerJson =new CreerJsonRegistraire(version);
        creerJson.CreerJson(listeCours);
        
        CreerFichierEchec creerFichiersEchec= new CreerFichierEchec(version);
        creerFichiersEchec.ecrireFichier(listeCours);


        
    }

}
