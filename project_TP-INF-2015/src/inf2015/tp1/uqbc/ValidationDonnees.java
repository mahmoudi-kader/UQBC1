package inf2015.tp1.uqbc;

/**
 *
 * Classe qui valide les donnees du cours
 */
public class ValidationDonnees {
      
    public static void validerNomCours(String cours){
        boolean valide = false;
        
        if(!(cours == null) && cours.length()==3 && estAlphabetique(cours)== true){
            valide = true;
        }else{
            valide = false;
        }
        if(!valide){
            throw new ValidationException("La valeur "+cours+" n'est pas valide.");
        }
    }
    
    public static void validerNumeroCours(String cours){
        boolean valide = false;
      
        if(!(cours == null) && cours.length()==4 && estNumerique(cours) == true ){
            valide = true;
        } else {
            valide = false;
        }
        if(!valide){
            throw new ValidationException("La valeur "+cours +" n'est pas valide comme numero de cours.");
        }
    }
    
    public static void validerGroupe(String groupe){
        boolean valide = false;
      
        if(!(groupe == null) && groupe.length()==4 ){
            if(groupe.substring(0,2).toUpperCase() == "GR"){
                if(estNumerique(groupe.substring(2,4)) == true){
                    valide = true;
                }else{
                    valide = false;
                }
            }else{
                valide = false;
            }
        } else {
            valide = false;
        }
        if(!valide){
            throw new ValidationException("La valeur "+groupe+" n'est pas valide");
        }
    }
    
    public static void validerSession(String cours){
        boolean valide = false;
      
        if(!(cours == null) && cours.length()==3 ){
            if(cours.substring(0,1).toUpperCase() == "H" || cours.substring(0,1).toUpperCase() == "E" || cours.substring(0,1).toUpperCase() == "A"){
                if(estNumerique(cours.substring(1,3)) == true){
                    valide = true;
                }else{
                    valide = false;
                }
            }else{
                valide = false;
            }
        } else {
            valide = false;
        }
        if(!valide){
            throw new ValidationException("La valeur "+cours+" n'est pas valide ");
        }
    }
    
    public static void validerCodePermanent(String codePermanent){
        boolean valide = false;
      
        if(!(codePermanent == null) && codePermanent.length()==12 ){
            if(estAlphabetique(codePermanent.substring(0,4)) == true){
                if(estNumerique(codePermanent.substring(4,12)) == true){
                    valide = true;
                }else{
                    valide = false;
                }
            }else{
                valide = false;
            }
        } else {
            valide = false;
        }
        if(!valide){
            throw new ValidationException("La valeur "+codePermanent+" n'est pas valide ");
        }
    }
    
    public static void validerTypeEvaluation(String typeEvaluation){
        boolean valide = false;
      
        if(!(typeEvaluation == null) && estAlphabetique(typeEvaluation) == true ){
            if(typeEvaluation.equalsIgnoreCase("Examen") || typeEvaluation.equalsIgnoreCase("Rapport") || typeEvaluation.equalsIgnoreCase("TP")){
                valide = true;
            }else{
                valide = false;
            }
        } else {
            valide = false;
        }
        if(!valide){
            throw new ValidationException("La valeur "+typeEvaluation+" n'est pas valide ");
        }
    }
    public static void validerNomEvaluation(String nomEvaluation, String typeEvaluation){
        boolean valide = false;
      
        if(!(nomEvaluation == null) && !(typeEvaluation == null) ){
            if(typeEvaluation.equalsIgnoreCase("Examen")){
                if(nomEvaluation.equalsIgnoreCase("Examen intra") || nomEvaluation.equalsIgnoreCase("Examen final") || nomEvaluation.equalsIgnoreCase("Quiz")){
                    valide = true;
                }else{
                    valide = false;
                }
            }else if(typeEvaluation.equalsIgnoreCase("Rapport")){
                if(nomEvaluation.startsWith("Rapport")){
                    valide = true;
                }else{
                    valide = false;
                }
            }else if(typeEvaluation.equalsIgnoreCase("TP")){
                if(nomEvaluation.startsWith("TP")){
                    valide = true;
                }else{
                    valide = false;
                }
            }else{
                valide = false;
            }
        } else {
            valide = false;
        }
        if(!valide){
            throw new ValidationException("La valeur "+nomEvaluation+" n'est pas valide ");
        }
    }   
    
    public static void validerPonderation(String ponderation){
        boolean valide = false;
      
        if(!(ponderation == null)){
            if(estNumerique(ponderation.substring(0, ponderation.length()-1)) == true){
                if(ponderation.substring(ponderation.length()-1)=="%"){
                    valide = true;
                }else{
                    valide = false;
                }
            } else {
                valide = false;
            }
        }
        if(!valide){
            throw new ValidationException("La valeur "+ponderation+" n'est pas valide ");
        }
    }
    
    private static boolean estNumerique(String str){
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    
    private static boolean estAlphabetique(String str){
        for (char c : str.toCharArray())
        {
            if (!(c >= 'a' && c <= 'z' ) && !(c >= 'A' && c <= 'Z' )) return false;
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
