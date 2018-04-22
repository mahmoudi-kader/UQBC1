package inf2015.tp1.uqbc;

import inf2015.tp1.uqbc.fichiers.CreerFichierEchec;
import inf2015.tp1.uqbc.fichiers.CreerJsonRegistraire;
import inf2015.tp1.uqbc.fichiers.CreerResultatsEtudiant;
import inf2015.tp1.uqbc.fichiers.CreerResultatsGroupeCours;
import inf2015.tp1.uqbc.fichiers.FichierJSON;
import inf2015.tp1.uqbc.fichiers.TraitementFichiers;
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
        List<FichierJSON> listeFichiers = new ArrayList();
        //Permet de lire tous les fichiers JSON
        TraitementFichiers.ramasser(repertoire, listeFichiers);
        List<Cours> listeCours = TraitementFichiers.chargerDonnees(listeFichiers);

        //Permet de sortir toutes les évaluations par étudiants
        CreerResultatsEtudiant creerDocument = new CreerResultatsEtudiant(version);
        creerDocument.ecrireFichier(listeCours);
        
        //Permet d'obtenir les statistiques des résultats des évaluations
        CreerResultatsGroupeCours resultatGroupeCours = new CreerResultatsGroupeCours();
        resultatGroupeCours.ecrireFichier(listeCours);
        
        //Permet de générer la note finale de chaque étudiant pour le régistraire
        CreerJsonRegistraire creerJson =new CreerJsonRegistraire();
        creerJson.CreerJson(listeCours);
        
        //Permet d'identifier les étudiants en échecs
        CreerFichierEchec creerFichiersEchec= new CreerFichierEchec();
        creerFichiersEchec.ecrireFichier(listeCours);
    }
}
