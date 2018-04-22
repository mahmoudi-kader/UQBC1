package inf2015.tp1.uqbc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cette class contient les constantes de l'application et les fonctions utilitaires
 */
public class Utilitaires {
    
    public static final String REPERTOIRE_PAR_DEFAUT = "./";
    public static final String FIN_LIGNE = System.lineSeparator();
    public static final String SEP_FICHIER = System.getProperty("file.separator");
    public static final String PREFIXE_FICHIER_LISTE_ETUDIANTS = "ListeEtudiantsCours";
    public static final String PREFIXE_FICHIER_NOTES = "evaluation";
    private long version = 0l;
    private static Utilitaires INSTANCE;
    
    private Utilitaires(long version){
        this.version =  version;
    }
    
    public static Utilitaires getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Utilitaires(System.currentTimeMillis());
        }
        
        return INSTANCE;
    }
    
    
    /**
     * Cette méthode retourne la ligne qui affiche la version du document.
     * @return String la version
     */
    public String getVersion(){
        return "Version : "+ new SimpleDateFormat("yyyy.MM.dd G 'à' HH:mm:ss z").format(new Date(this.version)) +FIN_LIGNE;
    }    
    
     /**
     * Cette méthode retourne la ligne qui affiche la version du document.
     * @return String la version
     */
    public String getVersionJSON(){
        return ""+ new SimpleDateFormat("yyyy.MM.dd G 'à' HH:mm:ss z").format( new Date(this.version));
    }    
    
}
