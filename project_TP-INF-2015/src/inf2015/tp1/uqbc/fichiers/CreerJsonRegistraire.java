package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.validation.ValidationEvaluations;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Cette classe sert a générer le fichier json a être envoyé au registraire.
 * @author Abdelkader
 * 
 */
public class CreerJsonRegistraire {

   private final static String FIN_LIGNE = System.lineSeparator();
   private final static String SEP_FICHIER = System.getProperty("file.separator");
        
   String repertoireDestination = "./";
   long version = 0l;

    public CreerJsonRegistraire(long version) throws IOException {
        
        this.version = version;
        
    }
   
   public void CreerJson(List<Cours> listeCours) throws IOException{
       
        JSONObject notes=new JSONObject();
        String cours_groupe="";    
        String nomCours="";
        JSONArray obj =null;
        //pour chaque cours
        if (listeCours != null) {
            for (Cours cours : listeCours) {
                obj = new JSONArray ();
                cours_groupe=cours.getTitre()+cours.getGroupe();
                ValidationEvaluations validatation =new ValidationEvaluations();
                if (validatation.validerPonderationComplete(cours)){
                    //recuperer les notes d'etudiants dans un tableau 
                    JSONObject sigle = new JSONObject();
                    sigle.put("sigle: ", cours.getTitre());
                    JSONObject groupe = new JSONObject();
                    groupe.put("Groupe: ", cours.getGroupe());
                    JSONObject note = new JSONObject();
                    JSONObject version = new JSONObject();
                    version.put("Version: ", getVersion());

                    obj.put(groupe);
                    obj.put(sigle);
                    obj.put(version);

                    List<Etudiant> etudiants = cours.getListeEtudiant();
                    JSONArray array = new JSONArray();
                    for (Etudiant etudiant : etudiants) {
                        JSONObject etudiantCourant = new JSONObject();
                        etudiantCourant.put("Code_permanent: ",etudiant.getCodePermanent());
                        etudiantCourant.put("Note: ", Calculs.calculNotePondereeGlobale(etudiants, cours.getListeEvaluation(), etudiant.getCodePermanent()));
                        array.put(etudiantCourant);
                    }
                    JSONObject notesEtudiantGroupe = new JSONObject();
                    notesEtudiantGroupe.put("Notes des etudiants: ", array);
                    obj.put(notesEtudiantGroupe);
                    
                    // remplir l'objet notes par les notes de'etudiants avant d'e l'afecter a obj
                    cours_groupe = cours.getTitre()+cours.getGroupe();
                    nomCours = cours.getTitre();
                }
                CreerResultatsEtudiant.creerRepertoire(repertoireDestination + nomCours);
                FileWriter writer = new FileWriter(repertoireDestination + nomCours + "/" + cours_groupe + ".json");  
                writer.write(obj.toString());
                writer.close();   
            }
        }
    }
   
     /**
     * Cette méthode retourne la ligne qui affiche la version du document.
     * @return String la version
     */
    protected String getVersion(){
        return ""+ new SimpleDateFormat("yyyy.MM.dd G 'à' HH:mm:ss z").format( new Date(this.version));
    }
   
}
