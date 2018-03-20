package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdelkader
 */
public class Evaluation {
 private String commentaire;
 private String numeroEvaluation;
 private String nomEvaluation;
 private String type;
 private String ponderation;
 private List<ResultatEvaluation> listeResultatEvaluation = new ArrayList<>();
 private double moyenneGroupeEvaluation=0;
    public Evaluation(){

    }
    
    public Evaluation(String commentaire, String numeroEvaluation, String nomEvaluation, String type, String ponderation){
        this.commentaire = commentaire;
        this.nomEvaluation = nomEvaluation;
        this.type = type;
        this.ponderation = ponderation;
        this.numeroEvaluation = numeroEvaluation;
        
    }
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getNomEvaluation() {
        return nomEvaluation;
    }

    public void setNomEvaluation(String nomEvaluation) {
        this.nomEvaluation = nomEvaluation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPonderation() {
        return ponderation;
    }

    public void setPonderation(String ponderation) {
        this.ponderation = ponderation;
    }

    public String getNumeroEvaluation() {
        return numeroEvaluation;
    }

    public void setNumeroEvaluation(String numeroEvaluation) {
        this.numeroEvaluation = numeroEvaluation;
    }

    public double getMoyenneGroupeEvaluation() {
        moyenneGroupeEvaluation = Calculs.calculMoyenneGroupeEvaluation(listeResultatEvaluation);
        return moyenneGroupeEvaluation;
    }

    public void setListeResultatEvaluation(List<ResultatEvaluation> listeResultatEvaluation) {
        this.listeResultatEvaluation = listeResultatEvaluation;
    }
    
    public List<ResultatEvaluation> getListeResultatEvaluation() {
        return listeResultatEvaluation;
    }
}