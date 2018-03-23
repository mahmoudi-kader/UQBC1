package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Evaluation;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui représente un fichier de notes de cours.
 *
 * @author benoit
 */
public class FichierNotesCours extends FichierJSON {

    Evaluation evaluation = null;
    private final String regex = "evaluation([0-9]++)([A-Z]{3})([0-9]++)-(Gr[\\d]*)-([HAE][\\d]{2})\\.json";

    @Override
    public boolean initialiserFichier(File fichier) {

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(fichier.getName());
        boolean succes = m.matches();
        if (succes) {

            this.setFichier(fichier);
            int groupCount = m.groupCount();
            this.evaluation = new Evaluation();
            evaluation.setNumeroEvaluation(m.group(1));

            setCours(new Cours());
            getCours().setTitre(m.group(2) + m.group(3));
            getCours().setNumeroCours(m.group(3));
            getCours().setGroupe(m.group(4));
            getCours().setSession(m.group(5));
        }

        return succes;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

}
