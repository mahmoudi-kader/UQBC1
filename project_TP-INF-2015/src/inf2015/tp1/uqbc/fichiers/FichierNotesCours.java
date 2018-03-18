package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Evaluation;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui représente un fichier de notes de cours.
 * @author benoit
 */
public class FichierNotesCours extends FichierJSON {
    
    private String regex = "evaluation([0-9]++)([A-Z]{3})([0-9]++)-(Gr[\\d]*)-([HAE][\\d]{2})\\.json";
    private Cours cours = null;
    
    @Override
    public boolean initialiserFichier(File fichier){
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(fichier.getName());
        boolean succes = m.matches();
        if(succes){
            int groupCount = m.groupCount();
            System.out.println("group count: "+m.groupCount());
            
            Evaluation evaluation = new Evaluation();
            evaluation.setNumeroEvaluation(m.group(1));
            
            setCours(new Cours());
            getCours().setTitre(m.group(2)+m.group(3));
            getCours().setNumeroCours(m.group(3));
            getCours().setGroupe(m.group(4));            
            getCours().setSession(m.group(5));
            
            
            System.out.println("Fichier:"+m.group(0));
            System.out.println("noEvaluation="+evaluation.getNumeroEvaluation());
            System.out.println("titre="+cours.getTitre());
            System.out.println("group="+cours.getGroupe());
            System.out.println("numeroCours="+cours.getNumeroCours());
            System.out.println("session="+cours.getSession());

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
