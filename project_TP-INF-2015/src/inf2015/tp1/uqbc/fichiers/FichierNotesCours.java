package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Evaluation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui représente un fichier de notes de cours.
 * @author benoit
 */
public class FichierNotesCours extends FichierJSON {
    
    private String regex = "evaluation([0-9]++)([A-Z]{3}[0-9]{4})-Gr([\\d]*)-([HAE][\\d]{2})\\.json";
    
    @Override
    public boolean testerNomFichier(String nomFichier){
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nomFichier);
        boolean succes = m.matches();
        if(succes){
            int groupCount = m.groupCount();
            System.out.println("group count: "+m.groupCount());
            
            Evaluation evaluation = new Evaluation();
            evaluation.setNumeroEvaluation(m.group(1));
            
            Cours cours = new Cours();
            cours.setTitre(m.group(2));
            cours.setGroupe(m.group(3));
            cours.setSession(m.group(4));
            
            System.out.println("Fichier:"+m.group(0));
            System.out.println("noEvaluation="+evaluation.getNumeroEvaluation());
            System.out.println("titre="+cours.getTitre());
            System.out.println("group="+cours.getGroupe());
            System.out.println("session="+cours.getSession());

        }
        
        
        return succes;
    }
    
}
