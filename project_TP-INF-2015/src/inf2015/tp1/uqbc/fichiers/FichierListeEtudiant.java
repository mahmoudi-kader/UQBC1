package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui représente un fichier de liste d'étudiants.
 * @author benoit
 */
public class FichierListeEtudiant extends FichierJSON {
 
    protected String regex = "ListeEtudiantsCours([1A-Z]{3}[0-9]{4})-Gr([\\d]*)-([HAE][\\d]{2})\\.json";
    
    
    /**
     * Cette méthode test si le nom du fichier correspond au format attendu.
     * Si oui, on associe les valeurs capturées aux variables.
     * @param nomFichier
     * @return 
     */
    @Override
     public boolean testerNomFichier(String nomFichier){
       
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nomFichier);
        boolean succes = m.matches();
        if(succes){
            int groupCount = m.groupCount();
            System.out.println("group count: "+m.groupCount());
            
            Cours cours = new Cours();
            cours.setTitre(m.group(1));
            cours.setGroupe(m.group(2));
            cours.setSession(m.group(3));
            
            System.out.println("Fichier:"+m.group(0));
            System.out.println("titre="+cours.getTitre());
            System.out.println("group="+cours.getGroupe());
            System.out.println("session="+cours.getSession());

        }
        
        return succes;
        
    }
    
    
}
