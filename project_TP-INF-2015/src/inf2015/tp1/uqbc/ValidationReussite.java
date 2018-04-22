package inf2015.tp1.uqbc;

import java.util.ArrayList;
import java.util.List;

/**
 *  Validation de la réussite des étudiants par cours
 * @author nawal
 */
public class ValidationReussite {
    private double note;
    private double ponderation;
    private double pourcentageReussite;
    
    public ValidationReussite() {
        this.note = 0;
        this.ponderation = 0;
        this. pourcentageReussite = 0;
    }
    
    public ValidationReussite(Cours cours, Etudiant etudiant) {
        this.note = Calculs.calculNoteGlobalEtudiant(cours, etudiant);
        this.ponderation = Calculs.calculPonderationGlobaleEtudiant(cours.getListeEtudiant(), cours.getListeEvaluation(), etudiant.getCodePermanent());
        this. pourcentageReussite = Calculs.calculPourcentageReussite(cours, etudiant);
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
