package inf2015.tp1.uqbc;

/**
 * Classe qui représente un étudiant.
 */
public class Etudiant {

    private String codePermanent;
    private String nom;
    private String prenom;

    public Etudiant() {

    }

    public Etudiant(String codePermanent, String nom, String prenom) {
        this.codePermanent = codePermanent;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getCodePermanent() {
        return codePermanent;
    }

    public void setCodePermanent(String codePermanent) {
        this.codePermanent = codePermanent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
