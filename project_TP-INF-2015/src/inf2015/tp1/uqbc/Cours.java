
package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Classe qui représente un cours
 */
public class Cours {
    private String jsonString;
    private String titre;
    private String groupe;
    private String session;
    private String commentaire;
    private String numeroCours;
    private List<Evaluation> listeEvaluation;
    private List<Etudiant> listeEtudiant;
    private double moyenneGroupe=0;
    
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
    
    public String getCommentaire() {
          return commentaire ; 
    }
    
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getNumeroCours() {
        return numeroCours;
    }

    public void setNumeroCours(String numeroCours) {
        this.numeroCours = numeroCours;
    }

    public double getMoyenneGroupe() {
        return moyenneGroupe;
    }
    
    public ArrayList<String> moyenneEtudiant(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation){
        ArrayList<String> listNoteEtudiants = new ArrayList();
        
        return listNoteEtudiants;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cours other = (Cours) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.groupe, other.groupe)) {
            return false;
        }
        if (!Objects.equals(this.session, other.session)) {
            return false;
        }
        if (!Objects.equals(this.numeroCours, other.numeroCours)) {
            return false;
        }
        return true;
    }

    
    
}
