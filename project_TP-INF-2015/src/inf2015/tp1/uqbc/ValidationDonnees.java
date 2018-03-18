package inf2015.tp1.uqbc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * La classe qui fait les validations
 */
public class ValidationDonnees {
    private String nomRepertoire;
    

    public String getNomRepertoire() {
        return nomRepertoire;
    }

    public void setNomRepertoire(String nomRepertoire) {
        this.nomRepertoire = nomRepertoire;
    }
    
    public void validerRepertoire(){
        String numeroEvaluation;
        int nombreLectureCours=0;
        int nombreLectureEvaluation=0;
        int nombreFichiers=0;
        String nomCours;
        String numeroCours;
        String groupe;
        String session;
        String identifiantListe = "ListeEtudiantsCours";
        String identifiantEvaluation = "evaluation";
        List <Cours> cours = new ArrayList<Cours>();
        Cours coursTemp;
        Evaluation evaluationTemp = new Evaluation();
        
        File rep = new File(getNomRepertoire());
        File[] fichiers = rep.listFiles();
        Arrays.sort(fichiers,Collections.reverseOrder());
        
        nombreFichiers=fichiers.length;
        System.out.println(nombreFichiers);
        for(int i =0; i < nombreFichiers ; i++ ){ //i < nombreFichiers  && 
            coursTemp = new Cours();
            if(fichiers[i].getName().startsWith(identifiantListe) ){
                nomCours= fichiers[i].getName().replaceAll(identifiantListe, "").substring(0,3);
                numeroCours= fichiers[i].getName().replaceAll(identifiantListe, "").substring(3,7);
                groupe= fichiers[i].getName().replaceAll(identifiantListe, "").substring(8,12);
                session= fichiers[i].getName().replaceAll(identifiantListe, "").substring(13,16);
                coursTemp.setTitre(nomCours);
                coursTemp.setGroupe(groupe);
                coursTemp.setSession(session);
                //coursTemp.setNumero(numeroCours);
                cours.add(coursTemp);
                nombreLectureCours++;
            }else if(fichiers[i].getName().startsWith(identifiantEvaluation) ){
                numeroEvaluation = fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(0,1);
                nomCours= fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(1,4);
                numeroCours= fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(4,8);
                groupe= fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(9,13);
                session= fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(14,17);
                if( ! cours.isEmpty() ){
                    for(int j=0; j<cours.size();j++){
                        if(nomCours.equalsIgnoreCase(cours.get(j).getTitre()) && groupe.equalsIgnoreCase(cours.get(j).getGroupe()) && session.equalsIgnoreCase(cours.get(j).getSession()) ){
                         //   evaluationTemp.setNumeroEvaluation(numeroEvaluation);
                            coursTemp=cours.get(j);
                         //   cours.set(j,coursTemp).setListeEvaluation(evaluationTemp);
                            nombreLectureEvaluation++;
                          //  cours.set(j,coursTemp).setListeEvaluation(evaluationTemp);
                        }
                    }
                }
            }
        }
        System.out.println(nombreLectureCours);
        System.out.println(nombreLectureEvaluation);
        System.out.println(cours.size());
    }
}
