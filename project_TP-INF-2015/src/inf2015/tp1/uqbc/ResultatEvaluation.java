package inf2015.tp1.uqbc;

/**
 * La classe qui représente un résultat d'évaluation pour un étudiant
 *
 * @author benoit
 */
public class ResultatEvaluation {

    private Etudiant etudiant;
    private Double note;

    public ResultatEvaluation() {

    }

    public ResultatEvaluation(Etudiant etudiant, Double note) {
        this.etudiant = etudiant;
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
