package inf2015.tp1.uqbc;

/**
 *
 * @author Abdelkader
 */
public class Evaluation {
 private String commentaire;
 private String nomEvaluation;
 private String type;
 private String ponderation;
 private List<ResultatEvaluation> listeEtudiant;

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

}