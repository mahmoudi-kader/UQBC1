
package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;

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
        moyenneGroupe = Calculs.calculMoyenneGroupeGlobale(listeEvaluation);
        return moyenneGroupe;
    }
    
    public ArrayList<String> moyenneEtudiant(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation){
        ArrayList<String> listNoteEtudiants = new ArrayList();
        double moyenneEtudiantGlobal = 0;
        for(Etudiant etudiant:listeEtudiant){
            moyenneEtudiantGlobal = Calculs.calculNotePondereeGlobale(listeEvaluation, etudiant.getCodePermanent());
            
        }
        return listNoteEtudiants;
    }

}
