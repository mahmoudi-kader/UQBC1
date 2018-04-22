package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Calculs;
import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Utilitaires;
import inf2015.tp1.uqbc.validation.ValidationEvaluations;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import static inf2015.tp1.uqbc.Utilitaires.REPERTOIRE_PAR_DEFAUT;

/**
 * Cette classe sert a générer le fichier json a être envoyé au registraire.
 * @author Abdelkader
 * 
 */
public class CreerJsonRegistraire {
   
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
                    version.put("Version: ", Utilitaires.getInstance().getVersionJSON());

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
                CreerResultatsEtudiant.creerRepertoire( REPERTOIRE_PAR_DEFAUT+ nomCours);
                FileWriter writer = new FileWriter(REPERTOIRE_PAR_DEFAUT + nomCours + "/" + cours_groupe + ".json");  
                writer.write(obj.toString());
                writer.close();   
            }
        }
    }
   

   
}
