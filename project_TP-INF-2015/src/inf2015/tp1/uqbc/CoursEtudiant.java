package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente un étudiant
 */
public class CoursEtudiant {

    private ArrayList<Object> listeCoursEtudiant;
    private String numeroEvaluation;
    private String nomEvaluation;
    private String type;
    private String ponderation;
    private double moyenneGroupeEvaluation = 0;
    private double note = 0;
    private Cours cours;
    private Etudiant etudiant;
    private Evaluation evaluation;

    public CoursEtudiant() {
        this.numeroEvaluation = null;
    }

    public CoursEtudiant(Cours cours, Etudiant etudiant, Evaluation evaluation) {
        rechercherEtudiant(cours, etudiant, evaluation);
    }

    public ArrayList<Object> getListeCoursEtudiant() {
        return listeCoursEtudiant;
    }

    public void setListeCoursEtudiant(ArrayList<Object> listeCoursEtudiant) {
        this.listeCoursEtudiant = listeCoursEtudiant;
    }

    public String getNumeroEvaluation() {
        return numeroEvaluation;
    }

    public void setNumeroEvaluation(String numeroEvaluation) {
        this.numeroEvaluation = numeroEvaluation;
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

    public double getMoyenneGroupeEvaluation() {
        return moyenneGroupeEvaluation;
    }

    public void setMoyenneGroupeEvaluation(double moyenneGroupeEvaluation) {
        this.moyenneGroupeEvaluation = moyenneGroupeEvaluation;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void rechercherEtudiant(Cours cours, Etudiant etudiant, Evaluation evaluation) {
        for (Evaluation evaluationTemp : cours.getListeEvaluation()) {
            if (evaluationTemp.getNumeroEvaluation().equalsIgnoreCase(evaluation.getNumeroEvaluation())) {
                for (ResultatEvaluation resultatEvaluation : evaluationTemp.getListeResultatEvaluation()) {
                    if (resultatEvaluation.getEtudiant().getCodePermanent().equalsIgnoreCase(etudiant.getCodePermanent())) {
                        this.numeroEvaluation = evaluation.getNumeroEvaluation();
                        this.nomEvaluation = evaluation.getNomEvaluation();
                        this.type = evaluation.getType();
                        this.ponderation = evaluation.getPonderation();
                        this.moyenneGroupeEvaluation = evaluation.getMoyenneGroupeEvaluation();
                        this.note = resultatEvaluation.getNote();
                    }
                }
            }
        }
    }
}
