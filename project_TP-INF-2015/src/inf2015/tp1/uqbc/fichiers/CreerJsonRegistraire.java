/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Abdelkader
 * 
 */

/*
En tant que registraire
Je veux obtenir les notes finales de chaque enseignant
Afin de générer les relevés de note.
Critères d’acceptation
Un fichier par groupe-cours, en format JSON;
Une note par étudiant; 
La note doit être sur 100;
Le fichier ne peut être généré que si toutes les évaluations, totalisant une pondération de 100%, ont été compilées.
Le fichier peut être regénéré au besoin, si l’enseignant a fait des changements;
Les étudiants doivent être identifiés par leur code permanent;
Le cours doit être identifié par son sigle;
Le groupe-cours doit être identifié par son numéro;
Le fichier est versionné avec la date et l’heure pour s’y retrouver parmi les multiples versions;

*/

 /*
        //json attendu pour chaque cours
    {
	"sigle": "sigle",
	"groupe": "groupe",
	"version": "version",
	"notes": [{
    			"matricule1": "note"
    		},
    		{
    			"matricule2": "note"
    		}
    	]
}
    */

public class CreerJsonRegistraire {

    String repertoireDestination = "C:/Users/Abdelkader/Desktop/UQBC/UQBC1/project_TP-INF-2015/";
   //    Map obj = new LinkedHashMap();

   JSONObject notes=new JSONObject();
   String cours_groupe="";
//    ObjectMapper o = new ObjectMapper();

    public CreerJsonRegistraire(List<Cours> listeCours) throws IOException {
    CreerJson( listeCours);
    }
   
   
   public void CreerJson(List<Cours> listeCours) throws IOException
           {
               
        List<Map> arrayMap = new ArrayList<Map>();
      //  Map<String, String> obj = new LinkedHashMap<String, String>();
        String notes="";
      JSONArray obj =new JSONArray ();
        //pour chaque cours
        if (listeCours != null) {
            for (Cours cours : listeCours) {
               ValidationEvaluations validatation =new ValidationEvaluations();
               if (validatation.validerPonderationComplete(cours))
                {
                    /*recuperer les notes d'etudiants dans un tableau sous la forme
                    [{"matricule": matricule,"note":note },
                    {"matricule": matricule,"note":note },
                            ...
                    ]
                    */
                    JSONObject sigle = new JSONObject();
                    sigle.put("sigle: ", cours.getTitre());
                    JSONObject groupe = new JSONObject();
                    groupe.put("groupe: ", cours.getGroupe());
                    JSONObject note = new JSONObject();
                    JSONObject version = new JSONObject();
                    version.put("version: ", new Date());

                    obj.put(groupe);
                    obj.put(sigle);
                    obj.put(version);

                    List<Etudiant> etudiants = cours.getListeEtudiant();
                    JSONArray array = new JSONArray();
                    for (Etudiant etudiant : etudiants) {
                        JSONObject etudiantCourant = new JSONObject();
                        etudiantCourant.put("code_permanent: ",etudiant.getCodePermanent());
                        etudiantCourant.put("Note: ", Calculs.calculNotePondereeGlobale(etudiants, cours.getListeEvaluation(), etudiant.getCodePermanent()));
                        array.put(etudiantCourant);
                    }
                    obj.put(array);
                    // remplir l'objet notes par les notes de'etudiants avant d'e l'afecter a obj
                    cours_groupe=cours.getTitre()+cours.getGroupe();
                }
                
               JSONObject json = new JSONObject(obj);
                File file =new File (repertoireDestination+"\\"+cours.getTitre()+"\\"+cours_groupe+".json") ;
                file.createNewFile();
                FileWriter writer =new FileWriter(file);  
                writer.write(obj.toString());
                writer.close();     
            }
         }

    }
}
