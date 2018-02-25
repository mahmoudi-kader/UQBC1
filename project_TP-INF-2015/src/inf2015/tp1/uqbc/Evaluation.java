
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
 private List <resultatEvaluation> listeEtudiant ;

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * @return the nomEvaluation
     */
    public String getNomEvaluation() {
        return nomEvaluation;
    }

    /**
     * @param nomEvaluation the nomEvaluation to set
     */
    public void setNomEvaluation(String nomEvaluation) {
        this.nomEvaluation = nomEvaluation;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the ponderation
     */
    public String getPonderation() {
        return ponderation;
    }

    /**
     * @param ponderation the ponderation to set
     */
    public void setPonderation(String ponderation) {
        this.ponderation = ponderation;
    }

}
