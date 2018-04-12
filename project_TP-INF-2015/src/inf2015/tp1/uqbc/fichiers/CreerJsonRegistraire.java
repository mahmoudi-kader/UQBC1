/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.ValidationEvaluations;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/**
 * Cette classe sert a générer le fichier json a être envoyé au registraire.
 * @author Abdelkader
 * 
 */
public class CreerJsonRegistraire {
   String repertoireDestination = "./";
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
