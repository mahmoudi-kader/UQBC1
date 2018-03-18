package inf2015.tp1.uqbc.fichiers;

import java.io.File;

/**
 * Classe Abstraite qui représente un fichier JSON.
 * @author benoit
 */
public abstract class FichierJSON {
    
    private String json;
    private File fichier;

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
    
}
