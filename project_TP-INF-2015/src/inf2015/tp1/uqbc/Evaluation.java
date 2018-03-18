package inf2015.tp1.uqbc;

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
 private List<ResultatEvaluation> listeResultatEvaluation;
 private double moyenneGroupeEvaluation=0;

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
        return moyenneGroupeEvaluation;
    }

}