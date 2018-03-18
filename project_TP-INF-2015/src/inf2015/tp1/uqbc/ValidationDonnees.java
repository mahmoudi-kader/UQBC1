package inf2015.tp1.uqbc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * Classe qui valide les donnees du cours
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
        int nombreFichiers=0;
        String nomCours;
        String numeroCours;
        String identifiantListe = "ListeEtudiantsCours";
        String identifiantEvaluation = "evaluation";
        List <Cours> cours = new ArrayList<Cours>();
        boolean coursTrouve = false;
        boolean evaluationCoursTrouve = false;
        
        File rep = new File(getNomRepertoire());
        File[] fichiers = rep.listFiles();
        Arrays.sort(fichiers,Collections.reverseOrder());
        
        cours.getClass();
        nombreFichiers=fichiers.length;
        for(int i =0; i < nombreFichiers ; i++ ){ //i < nombreFichiers  && 
            if(fichiers[i].getName().startsWith(identifiantListe) ){
                nomCours= fichiers[i].getName().replaceAll(identifiantListe, "").substring(0,3);
                numeroCours= fichiers[i].getName().replaceAll(identifiantListe, "").substring(3,7);
                coursTrouve = true;
            }else if(fichiers[i].getName().startsWith(identifiantEvaluation) ){
                numeroEvaluation = fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(0,1);
                nomCours= fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(1,4);
                numeroCours= fichiers[i].getName().replaceAll(identifiantEvaluation, "").substring(4,8);
                if( ! cours.isEmpty() ){
                    for(int j=0; j<cours.size();j++){
                        if(nomCours.equalsIgnoreCase(cours.get(j).getTitre()) && numeroCours.equalsIgnoreCase(cours.get(j).getNumeroCours())){
                            evaluationCoursTrouve = true;
                        }
                    }
                }
            }
        }
    }
    
    public boolean validerNomCours(String cours){
        boolean nomValide = false;
        
        if(!(cours == null) && cours.length()==3 && estAlphabetique(cours)== true){
            nomValide = true;
        }else{
            nomValide = false;
        }
        return nomValide;
    }
    
    public boolean validerNumeroCours(String cours){
        boolean nomValide = false;
      
        if(!(cours == null) && cours.length()==4 && estNumerique(cours) == true ){
            nomValide = true;
        } else {
            nomValide = false;
        }
        return nomValide;
    }
    
    public boolean validerGroupe(String cours){
        boolean nomValide = false;
      
        if(!(cours == null) && cours.length()==4 ){
            if(cours.substring(0,2).toUpperCase() == "GR"){
                if(estNumerique(cours.substring(2,4)) == true){
                    nomValide = true;
                }else{
                    nomValide = false;
                }
            }else{
                nomValide = false;
            }
        } else {
            nomValide = false;
        }
        return nomValide;
    }
    
    public boolean validerSession(String cours){
        boolean nomValide = false;
      
        if(!(cours == null) && cours.length()==3 ){
            if(cours.substring(0,1).toUpperCase() == "H" || cours.substring(0,1).toUpperCase() == "E" || cours.substring(0,1).toUpperCase() == "A"){
                if(estNumerique(cours.substring(1,3)) == true){
                    nomValide = true;
                }else{
                    nomValide = false;
                }
            }else{
                nomValide = false;
            }
        } else {
            nomValide = false;
        }
        return nomValide;
    }
    
    public boolean validerCodePermanent(String cours){
        boolean nomValide = false;
      
        if(!(cours == null) && cours.length()==12 ){
            if(estAlphabetique(cours.substring(0,4)) == true){
                if(estNumerique(cours.substring(4,12)) == true){
                    nomValide = true;
                }else{
                    nomValide = false;
                }
            }else{
                nomValide = false;
            }
        } else {
            nomValide = false;
        }
        return nomValide;
    }
    
    public boolean validerTypeEvaluation(String cours){
        boolean nomValide = false;
      
        if(!(cours == null) && estAlphabetique(cours) == true ){
            if(cours.equalsIgnoreCase("Examen") || cours.equalsIgnoreCase("Rapport") || cours.equalsIgnoreCase("TP")){
                nomValide = true;
            }else{
                nomValide = false;
            }
        } else {
            nomValide = false;
        }
        return nomValide;
    }
    public boolean validerNomEvaluation(String nomEvaluation, String typeEvaluation){
        boolean nomValide = false;
      
        if(!(nomEvaluation == null) && !(typeEvaluation == null) && estAlphabetique(nomEvaluation) == true ){
            if(typeEvaluation.equalsIgnoreCase("Examen")){
                if(nomEvaluation.equalsIgnoreCase("Examen intra") || nomEvaluation.equalsIgnoreCase("Examen final") || nomEvaluation.equalsIgnoreCase("Quiz")){
                    nomValide = true;
                }else{
                    nomValide = false;
                }
            }else if(typeEvaluation.equalsIgnoreCase("Rapport")){
                if(nomEvaluation.startsWith("Rapport")){
                    nomValide = true;
                }else{
                    nomValide = false;
                }
            }else if(typeEvaluation.equalsIgnoreCase("TP")){
                if(nomEvaluation.startsWith("TP")){
                    nomValide = true;
                }else{
                    nomValide = false;
                }
            }else{
                nomValide = false;
            }
        } else {
            nomValide = false;
        }
        return nomValide;
    }
    
    public boolean validerNote(String ponderation){
        boolean nomValide = false;
      
        if(!(ponderation == null) && estDouble(ponderation) == true ){
            nomValide = true;
        } else {
            nomValide = false;
        }
        return nomValide;
    }
    
    public boolean validerPonderation(String ponderation){
        boolean nomValide = false;
      
        if(!(ponderation == null)){
            if(estNumerique(ponderation.substring(0, ponderation.length()-1)) == true){
                if(ponderation.substring(ponderation.length()-1)=="%"){
                    nomValide = true;
                }else{
                    nomValide = false;
                }
            } else {
                nomValide = false;
            }
        }
        return nomValide;
    }
    
    private boolean estNumerique(String str){
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    
    private boolean estAlphabetique(String str){
        for (char c : str.toCharArray())
        {
            if (!(c >= 'a' && c <= 'z' )) return false;
        }
        return true;
    }
    
    private static boolean estDouble(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;		
	}
}
