package inf2015.tp1.uqbc.fichiers;

import java.io.File;
import java.util.List;

/**
 * Cette class va ramasser tous les fichiers du répertoire, et les mettre dans une liste.
 * Si un répertoire est rencontré, on exécute la même logique dans le répertoire.
 * 
 * @author benoit
 */
public class TraitementFichiers {
    
    private static final String defaultWorkingDirectory = "./";
    private static final String PREFIXE_FICHIER_LISTE_ETUDIANTS = "ListeEtudiantsCours";
    private static final String PREFIXE_FICHIER_NOTES = "evaluation";
    
    /**
     * ramasser tous les fichiers du répertoire, et les mettre dans une liste.
     * Si un répertoire est rencontré, on exécute la même méthode dans le répertoire
     * Si la variable repertoire est nulle, on utilise le répertoire courant.
     * Si la variable liste est nulle, on lance une exception.
     * @param repertoire
     * @param liste 
     */
    public static void ramasser(String repertoire, List<FichierJSON> liste){
        if(repertoire == null || repertoire.length() == 0){
            repertoire = defaultWorkingDirectory;
        }
        
        if(liste == null){
            throw new RuntimeException("La variable 'liste' doit être initialisée.");
        }
        
        File repertoireTravail = new File(repertoire);
        
        if(! repertoireTravail.exists() || !repertoireTravail.isDirectory() || repertoireTravail.canRead() ){
            throw new RuntimeException("Le répertoire : '"+repertoire+"' n'est pas un répertoire ou n'est pas accessible." );    
        }
        
        File[] listeFichiers = repertoireTravail.listFiles();
                      
        for(File fichier : listeFichiers){
            if(fichier.isDirectory()){
                ramasser(fichier.getAbsolutePath(),liste);
            }else{
                
                FichierJSON fichierJSON = null;
                if(fichier.getName().startsWith(PREFIXE_FICHIER_LISTE_ETUDIANTS)){
                    
                    fichierJSON = new FichierListeEtudiant();
                    
                }else if(fichier.getName().startsWith(PREFIXE_FICHIER_NOTES)){
                    
                    fichierJSON = new FichierNotesCours();
                    
                }else{
                    throw new RuntimeException("Le nom du fichier '"+fichier.getName()+"' n'est pas un format reconnu.");
                }
                fichierJSON.initialiserFichier(fichier);
                liste.add(fichierJSON);
            }
        }
        
    }
    
}
