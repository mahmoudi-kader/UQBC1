/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Abdelkader
 */
public class CoursEtudiant {
    
        private List <Object> listeCoursEtudiant;
        private String numeroEvaluation;
        private String nomEvaluation;
        private String type;
        private String ponderation;
        private double moyenneGroupeEvaluation=0; 
        private double note=0;
        private Cours cours;
        private Etudiant etudiant;

    public CoursEtudiant() {
        this.listeCoursEtudiant = new ArrayList<>();
    }

    /**
     * @return the listeCoursEtudiant
     */
    public List <Object> getListeCoursEtudiant() {
        return listeCoursEtudiant;
    }

    /**
     * @param listeCoursEtudiant the listeCoursEtudiant to set
     */
    public void setListeCoursEtudiant(List <Object> listeCoursEtudiant) {
        this.listeCoursEtudiant = listeCoursEtudiant;
    }

    /**
     * @return the numeroEvaluation
     */
    public String getNumeroEvaluation() {
        return numeroEvaluation;
    }

    /**
     * @param numeroEvaluation the numeroEvaluation to set
     */
    public void setNumeroEvaluation(String numeroEvaluation) {
        this.numeroEvaluation = numeroEvaluation;
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

    /**
     * @return the moyenneGroupeEvaluation
     */
    public double getMoyenneGroupeEvaluation() {
        return moyenneGroupeEvaluation;
    }

    /**
     * @param moyenneGroupeEvaluation the moyenneGroupeEvaluation to set
     */
    public void setMoyenneGroupeEvaluation(double moyenneGroupeEvaluation) {
        this.moyenneGroupeEvaluation = moyenneGroupeEvaluation;
    }

    /**
     * @return the note
     */
    public double getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(double note) {
        this.note = note;
    }

    /**
     * @return the cours
     */
    public Cours getCours() {
        return cours;
    }

    /**
     * @param cours the cours to set
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    /**
     * @return the etudiant
     */
    public Etudiant getEtudiant() {
        return etudiant;
    }

    /**
     * @param etudiant the etudiant to set
     */
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

}
