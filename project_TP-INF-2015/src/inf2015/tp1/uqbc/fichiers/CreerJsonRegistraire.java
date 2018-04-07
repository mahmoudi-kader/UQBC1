/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ValidationEvaluations;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
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
	"notes": {
		"matricule1": "note",
		"matricule2": "note"
	}
}
    */
public class CreerJsonRegistraire {
   String repertoireDestination = "C:/Users/nawal/Documents/NetBeansProjects/UQBC1/project_TP-INF-2015/";
   JSONObject obj = new JSONObject();
   JSONObject notes=new JSONObject();
   String cours_groupe="";
   
   public CreerJsonRegistraire(List<Cours> cour) throws IOException
           {
        //pour chaque cours
        if (cour != null) {
            for (Cours course : cour) {
               ValidationEvaluations validatation =new ValidationEvaluations();
               if (validatation.validerPonderationComplete(course))
                {
                    
                obj.put("sigle", course.getTitre());
                obj.put("groupe", course.getGroupe());
                obj.put("version", new Date());
                // remplir l'objet notes par les notes de'etudiants avant d'e l'afecter a obj
                obj.put("notes", notes);
                cours_groupe=course.getTitre()+course.getGroupe();
                 }
                   
            }
            // ecrire obj dans un fichier json qui porte le nom du cours+ groupe
            
            File file =new File (repertoireDestination+"\\"+cours_groupe+".json") ;
            file.createNewFile();
            FileWriter writer =new FileWriter(file);  
            writer.write(obj.toString());
            writer.close();
         }

    }
}
