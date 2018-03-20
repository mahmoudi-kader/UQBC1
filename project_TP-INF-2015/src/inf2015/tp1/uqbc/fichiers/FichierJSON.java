package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import java.io.File;

/**
 * Classe Abstraite qui représente un fichier JSON.
 * @author benoit
 */
public abstract class FichierJSON {
    
    private String json;
    private File fichier;
    private Cours cours = null;

    public abstract boolean initialiserFichier(File fichier);
    
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public File getFichier() {
        return fichier;
    }

    public void setFichier(File fichier) {
        this.fichier = fichier;
    }
    
    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }  
    
}
