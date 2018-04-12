package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ValidationEvaluations;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Créer le fichier pour le registraire dans les mêmes répertoires 
 * que les résultats des étudiants
 * @author Abdelkader
 * 
 */

public class CreerJsonRegistraire {

    String repertoireDestination = "./";

    public CreerJsonRegistraire(List<Cours> listeCours) throws IOException {
    CreerJson( listeCours);
    }
   
   public void CreerJson(List<Cours> listeCours) throws IOException{
            JSONObject notes=new JSONObject();
        String cours_groupe="";    
        String nomCours="";
        JSONArray obj =new JSONArray ();
        //pour chaque cours
        if (listeCours != null) {
            for (Cours cours : listeCours) {
                cours_groupe=cours.getTitre()+cours.getGroupe();
                ValidationEvaluations validatation =new ValidationEvaluations();
                if (validatation.validerPonderationComplete(cours)){
                    //recuperer les notes d'etudiants dans un tableau 
                    JSONObject sigle = new JSONObject();
                    sigle.put("sigle: ", cours.getTitre());
                    JSONObject groupe = new JSONObject();
                    groupe.put("Groupe: ", cours.getGroupe());
                    JSONObject note = new JSONObject();
                    //JSONObject version = new JSONObject();
                    //version.put("Version: ", new Date());

                    obj.put(groupe);
                    obj.put(sigle);
                    //obj.put(version);

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
                File file = new File(repertoireDestination + nomCours + "/" + cours_groupe + ".json");
                file.createNewFile();
                FileWriter writer = new FileWriter(file);  
                writer.write(obj.toString());
                writer.close();   
            }
        }
    }
}
