package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui représente un fichier de liste d'étudiants.
 * @author benoit
 */
public class FichierListeEtudiant extends FichierJSON {
 
    protected String regex = "ListeEtudiantsCours([1A-Z]{3})([0-9]{4})-(Gr[\\d]*)-([HAE][\\d]{2})\\.json";
    private Cours cours = null;
    
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
            
            setCours(new Cours());
            getCours().setTitre(m.group(1)+m.group(2));
            getCours().setNumeroCours(m.group(2));
            getCours().setGroupe(m.group(3));            
            getCours().setSession(m.group(4));
            
            System.out.println("Fichier:"+m.group(0));
            System.out.println("titre="+getCours().getTitre());
            System.out.println("group="+getCours().getGroupe());
            System.out.println("group="+getCours().getNumeroCours());
            System.out.println("session="+getCours().getSession());

        }
        
        return succes;
        
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    
}
