package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui représente un fichier de liste d'étudiants.
 * @author benoit
 */
public class FichierListeEtudiant extends FichierJSON {
 
    protected String regex = "ListeEtudiantsCours([1A-Z]{3})([0-9]{4})-(Gr[\\d]*)-([HAE][\\d]{2})\\.json";
    
    /**
     * Cette méthode test si le nom du fichier correspond au format attendu.
     * Si oui, on associe les valeurs capturées aux variables.
     * @param nomFichier
     * @return 
     */
    @Override
     public boolean initialiserFichier(File fichier){
       
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(fichier.getName());
        boolean succes = m.matches();
        if(succes){
            
            this.setFichier(fichier);
            int groupCount = m.groupCount();
            
            setCours(new Cours());
            getCours().setTitre(m.group(1)+m.group(2));
            getCours().setNumeroCours(m.group(2));
            getCours().setGroupe(m.group(3));            
            getCours().setSession(m.group(4));

        }
        
        return succes;
        
    }
    
}
