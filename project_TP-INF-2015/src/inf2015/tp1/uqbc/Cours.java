
package inf2015.tp1.uqbc;

import java.util.List;

/*
 * Classe qui représente un cours
 */
public class Cours {
    private String titre;
    private String groupe;
    private String session;
    private List<Evaluation> listeEvaluation;
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
    
    
}
