package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ValidationDonnees;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

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
                
                if(!fichier.canRead()){
                    throw new RuntimeException("Le fichier '"+fichier.getAbsolutePath()+"' n'est pas accessible.");
                }
                
                
                FichierJSON fichierJSON = null;
                if(fichier.getName().startsWith(PREFIXE_FICHIER_LISTE_ETUDIANTS)){
                    
                    fichierJSON = new FichierListeEtudiant();
                    
                }else if(fichier.getName().startsWith(PREFIXE_FICHIER_NOTES)){
                    
                    fichierJSON = new FichierNotesCours();
                    
                }else{
                    throw new RuntimeException("Le nom du fichier '"+fichier.getName()+"' n'est pas un format reconnu.");
                }
                fichierJSON.initialiserFichier(fichier);
                fichierJSON.setJson(FileReader.StringFromFile(fichier.getAbsolutePath()));                
                liste.add(fichierJSON);
            }
        }
        
    }
    
    
    public static List<Cours> chargerDonnees(Map<Cours, FichierJSON> map){
        
        List<Cours> listeCours = new ArrayList();
        
        Set<Cours> set =  map.keySet();
        for(Cours cours : set){
            
            FichierJSON fichier = map.get(cours);
            String szJson = fichier.getJson();
            JSONObject jsonObj = new JSONObject(szJson);
            
            if(fichier instanceof FichierNotesCours){
                Evaluation eval = new Evaluation();
                
                String commentaire = jsonObj.getString("commentaire");
                String nomEvaluation = jsonObj.getString("nom_evaluation");
                String ponderation = jsonObj.getString("ponderation");
                String typeEvaluation = jsonObj.getString("type");
                
                eval.setCommentaire(commentaire);
                eval.setNomEvaluation(nomEvaluation);
                eval.setType(jsonObj.getString("type"));
                eval.setPonderation(ponderation);
                
                boolean valide = true;
                valide = valide && ValidationDonnees.validerNomEvaluation(nomEvaluation, szJson);
                valide = valide && ValidationDonnees.validerPonderation(ponderation);
                
                        
                cours.getListeEvaluation().add(eval);
                
            }else{
                
                
                
                
            }
            
        }
        
        
        
        return listeCours;
    }
    
 
}
