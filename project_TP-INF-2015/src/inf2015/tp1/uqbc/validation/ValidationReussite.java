package inf2015.tp1.uqbc.validation;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import java.util.ArrayList;
import java.util.List;

/**
 *  Validation de la réussite des étudiants par cours
 * @author nawal
 */
public class ValidationReussite {
    private Etudiant etudiant;
    private double note;
    private double ponderation;
    private double pourcentageReussite;
    
    public ValidationReussite() {
        this.etudiant = null;
        this.note = 0;
        this.ponderation = 0;
        this. pourcentageReussite = 0;
    }
    
    public ValidationReussite(Cours cours, Etudiant etudiant) {
        this.etudiant = etudiant;
        this.note = Calculs.calculNoteGlobalEtudiant(cours, etudiant);
        this.ponderation = Calculs.calculPonderationGlobaleEtudiant(cours.getListeEtudiant(), cours.getListeEvaluation(), etudiant.getCodePermanent());
        this. pourcentageReussite = Calculs.calculPourcentageReussite(cours, etudiant);
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public double getNote() {
        return note;
    }
    
    public double getPonderation() {
        return ponderation;
    }
    
    public double getPourcentageReussite() {
        return pourcentageReussite;
    }
}
