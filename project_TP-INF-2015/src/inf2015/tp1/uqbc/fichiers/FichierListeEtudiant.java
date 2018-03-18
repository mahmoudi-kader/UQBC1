package inf2015.tp1.uqbc.fichiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui représente un fichier de liste d'étudiants.
 * @author benoit
 */
public class FichierListeEtudiant extends FichierJSON {
 
    protected String regex = "ListeEtudiantsCours[A-Z]{3}[0-9]{4}-Gr[\\d]*-[HAE][\\d]{2}\\.json";
    
    
    /**
     * Cette méthode test si le nom du fichier correspond au format attendu.
     * Si oui, on associe les valeurs capturées aux variables.
     * @param nomFichier
     * @return 
     */
        public boolean testerNomFichier(String nomFichier){
       
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nomFichier);
        m.
        boolean succes = m.matches();
        if(succes){
            int groupCount = m.groupCount();
            System.out.println("group count: "+m.groupCount());
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(m.group(4));
            System.out.println(m.group(5));
        }
        
        return succes;
        
    }
    
    
}
