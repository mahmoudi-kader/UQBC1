
package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Classe qui représente un cours
 */
public class Cours {

    private String titre;
    private String groupe;
    private String session;
    private String commentaire;
    private String numeroCours;
    private List<Evaluation> listeEvaluation = new ArrayList();
    private List<Etudiant> listeEtudiant = new ArrayList();
    
    public Cours(){
        
    }
    public Cours(String titre, String groupe, String session, String commentaire, String numeroCours){
        this.titre = titre;
        this.groupe = groupe;
        this.session = session;
        this.commentaire = commentaire;
        this.numeroCours = numeroCours;
    }
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
        double moyenneGroupe= Calculs.calculMoyenneGroupeGlobale(getListeEtudiant(), getListeEvaluation());
        return moyenneGroupe;
    }
    
    public double getPonderationGroupe() {
        double ponderationGroupe= Calculs.calculPonderationGroupeGlobale(getListeEtudiant(), getListeEvaluation());
        return ponderationGroupe;
    }
    
    public ArrayList<String> noteEtudiantGlobal(List<Etudiant> listeEtudiant, List<Evaluation> listeEvaluation){
        ArrayList<String> listNoteEtudiants = new ArrayList();
        double noteEtudiantGlobal = 0;
        for(Etudiant etudiant:listeEtudiant){
            noteEtudiantGlobal = Calculs.calculNotePondereeGlobale(getListeEtudiant(), listeEvaluation, etudiant.getCodePermanent());
            listNoteEtudiants.add(etudiant.getCodePermanent() + " : " + noteEtudiantGlobal);
        }
        return listNoteEtudiants;
    }
    
    public void setListeEvaluation(List<Evaluation> listeEvaluation) {
        this.listeEvaluation = listeEvaluation;
    }

    public void setListeEtudiant(List<Etudiant> listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.titre);
        hash = 83 * hash + Objects.hashCode(this.groupe);
        hash = 83 * hash + Objects.hashCode(this.session);
        hash = 83 * hash + Objects.hashCode(this.numeroCours);
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
    



    /**
     * @return the listeEvaluation
     */
    public List<Evaluation> getListeEvaluation() {
        return listeEvaluation;
    }

    /**
     * @return the listeEtudiant
     */
    public List<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }

    
    
    
}
